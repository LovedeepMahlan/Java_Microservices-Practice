package com.RequestDespacher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "Sending request from one servlet to another", urlPatterns={"/First"})
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//While dispatching the request the new request object will be created and data of 
		//request objected will be transfered into new object
		System.out.println("First servlet reqest object ::"+request.getClass().getName());
		//While dispatching the response object same object will send but all data will be flushed
		System.out.println("First servlet response hashcode ::"+response.getClass().getName());
		System.out.println("REquest Processing");
		PrintWriter out=response.getWriter();
		//out.flush(); after flush the printWriter object request will no be transfer from one servlet to another servlet;
		//we can send the request through absolute path also but good programming practice is send th request by relative path
		RequestDispatcher rd=request.getRequestDispatcher("/Second");
		request.setAttribute("Name", "Lovedeep");
		request.setAttribute("Age", "18");
		out.println("<h1 align='center' color='pink'>Request from first servlet</h1>");
		rd.forward(request, response);
		System.out.println(10/0);//After sending the request if our code give an error then it will no be a part of project
	}

}
