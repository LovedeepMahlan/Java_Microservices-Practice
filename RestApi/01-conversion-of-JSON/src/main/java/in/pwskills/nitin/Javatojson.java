package in.pwskills.nitin;

import java.io.File;
import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.pwskills.nitin.beans.Student;

public class Javatojson {

	public static void main(String[] args) {
		ObjectMapper mapper=new ObjectMapper();
		
		Student student=new Student(12, "Rohit", List.of("Nikhil","Ronak","Ankit"));
		
		String jsonStudent;
		try {
			jsonStudent = mapper.writeValueAsString(student);
			System.out.println(jsonStudent);
			
			mapper.writeValue(new File("Student.Json"), student);
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
