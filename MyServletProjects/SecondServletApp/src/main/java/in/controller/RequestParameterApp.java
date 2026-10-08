package in.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestParameterApp
 */
@WebServlet(description = "Working with Request Object", urlPatterns = { "/Demo" },loadOnStartup = 5)
public class RequestParameterApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static {
		System.out.println("Loading of RequestParameterApp");
	}
	public RequestParameterApp() {
		System.out.println("Instantation of .class file");
	}
	@Override
	public void init() throws ServletException {
		System.out.println("Intialization init()... with zero argument");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String contactnumber=request.getParameter("contactnumber");
		String[] Course=request.getParameterValues("Course");
		String status="Registration Successfull";	
		PrintWriter out=response.getWriter();
		out.println("<body align='center' bgcolor='red'");
		out.println("<h1>Student Registration form </h1>");
		out.println("<table align='center' border='1'>");
		out.println("<tr><th>NAME</th><th>CONTACTNUMBER</th><th>COURSES</th><th>STATUS</th></tr>");
		out.println("<tr>");
		out.println("<td>" + username + "</td>");
		out.println("<td>" + contactnumber + "</td>");
		out.println("<td>");

		for (String course : Course) {
			out.println(course + "<br/>");
		}
		out.println("</td>");
		out.println("<td>" + status + "</td>");

		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
		out.close();
	}
}
