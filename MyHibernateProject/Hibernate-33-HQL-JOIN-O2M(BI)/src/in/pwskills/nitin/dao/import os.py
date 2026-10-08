import os
import numpy as np
import torch
import streamlit as st
import pdfplumber  # ✅ Better alternative to fitz
import faiss
from sentence_transformers import SentenceTransformer
from transformers import AutoTokenizer, AutoModelForSeq2SeqLM, pipeline
from keybert import KeyBERT
import pyttsx3
import speech_recognition as sr

# -------------------- Initialize Streamlit Page ------------------------
st.set_page_config(page_title="📚 AI Super Tutor", layout="wide", initial_sidebar_state="expanded")
st.title("📚🎧 Welcome to Your AI Super Tutor!")
st.caption("Open-source, no API keys, just brains and code. 🧠💻")

# -------------------- Load Models ------------------------
@st.cache_resource(show_spinner="Loading models... ⚡")
def load_models():
    embed_model = SentenceTransformer('all-MiniLM-L6-v2')
    draft_tokenizer = AutoTokenizer.from_pretrained("google/flan-t5-base")
    draft_model = AutoModelForSeq2SeqLM.from_pretrained("google/flan-t5-base")
    keyword_extractor = KeyBERT(model='all-MiniLM-L6-v2')
    return embed_model, draft_model, draft_tokenizer, keyword_extractor

embed_model, draft_model, draft_tokenizer, keyword_extractor = load_models()

# -------------------- Initialize Session State ------------------------
if "docs_db" not in st.session_state:
    st.session_state.docs_db = {}

# -------------------- Helper Functions ------------------------
def extract_text_from_pdf(uploaded_file):
    """Extract text from a PDF file using pdfplumber."""
    text = ""
    with pdfplumber.open(uploaded_file) as pdf:
        for page in pdf.pages:
            text += page.extract_text() or ""
    return text

def chunk_text(text, max_chars=500):
    """Chunk text into manageable parts."""
    paragraphs = text.split("\n")
    chunks, current = [], ""
    for para in paragraphs:
        if len(current) + len(para) < max_chars:
            current += " " + para
        else:
            chunks.append(current.strip())
            current = para
    if current:
        chunks.append(current.strip())
    return [c for c in chunks if len(c.split()) > 10]

def speak_text(text):
    """Speak text using pyttsx3."""
    engine = pyttsx3.init()
    engine.setProperty('rate', 170)
    engine.setProperty('volume', 1.0)
    voices = engine.getProperty('voices')
    if voices:
        engine.setProperty('voice', voices[1].id)
    engine.say(text)
    engine.runAndWait()

def answer_query(subject, query):
    """Main logic to answer a user's query."""
    docs = st.session_state.docs_db[subject]["docs"]
    index = st.session_state.docs_db[subject]["index"]

    keywords = keyword_extractor.extract_keywords(query, top_n=5)
    query_vec = embed_model.encode([query])
    D, I = index.search(np.array(query_vec), k=4)
    top_docs = [docs[i] for i in I[0]]

    draft_prompt = f"""
Context:
{'\n'.join(top_docs)}

Student's Question:
{query}

Provide a clear, detailed, and friendly explanation with examples.
"""
    draft_pipe = pipeline("text2text-generation", model=draft_model, tokenizer=draft_tokenizer, device=0 if torch.cuda.is_available() else -1)
    final_answer = draft_pipe(draft_prompt, max_new_tokens=768)[0]['generated_text']
    return final_answer

# Function for audio-to-text conversion using speech_recognition
def audio_to_text():
    """Capture audio from the microphone and convert to text."""
    recognizer = sr.Recognizer()
    with sr.Microphone() as source:
        st.write("🎤 Listening... Speak now!")
        audio = recognizer.listen(source, timeout=8)  # Listen for 8 seconds
        
    try:
        query_text = recognizer.recognize_google(audio)  # Using Google Web Speech API
        st.write(f"📜 You asked: {query_text}")
        return query_text
    except sr.UnknownValueError:
        st.error("Sorry, I couldn't understand the audio.")
        return None
    except sr.RequestError:
        st.error("Could not request results from Google Speech Recognition service.")
        return None

# -------------------- Sidebar: Upload PDFs ------------------------
st.sidebar.header("📄 Upload Your PDFs")
uploaded_files = st.sidebar.file_uploader("Upload syllabus PDFs:", type=["pdf"], accept_multiple_files=True)

if uploaded_files:
    for file in uploaded_files:
        subject_name = file.name
        raw_text = extract_text_from_pdf(file)
        docs = chunk_text(raw_text)
        embeddings = embed_model.encode(docs)
        dimension = embeddings.shape[1]
        index = faiss.IndexFlatL2(dimension)
        index.add(np.array(embeddings))

        st.session_state.docs_db[subject_name] = {
            "docs": docs,
            "index": index,
        }
    st.sidebar.success(f"✅ {len(uploaded_files)} PDFs processed!")

# -------------------- Main Interaction Area ------------------------
if st.session_state.docs_db:
    st.subheader("🎯 Select Subject and Ask Your Question")

    selected_subject = st.selectbox("Choose the subject:", list(st.session_state.docs_db.keys()))

    # Option to use text input or voice input
    query_option = st.radio("How would you like to ask the question?", ("Text Input", "Voice Input"))

    if query_option == "Text Input":
        query = st.text_input("Type your question here:")
    else:
        query = None
        if st.button("🎤 Start Voice Input"):
            query = audio_to_text()

    if query:
        with st.spinner("🧠 Thinking deeply..."):
            final_answer = answer_query(selected_subject, query)

        st.subheader("📖 AI Tutor's Lesson:")
        st.write(final_answer)

        if st.button("🔊 Speak Out Loud"):
            with st.spinner("🔈 Speaking your answer..."):
                speak_text(final_answer)
else:
    st.warning("📂 Please upload at least one PDF to start tutoring!")

# -------------------- Footer ------------------------
st.markdown("---")
st.caption("Built with ❤ for students. | 100% open-source AI magic.")