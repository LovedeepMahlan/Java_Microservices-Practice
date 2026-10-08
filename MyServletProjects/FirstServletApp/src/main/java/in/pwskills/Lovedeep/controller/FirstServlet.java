package in.pwskills.Lovedeep.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet(description="Working with get and post methods",urlPatterns="/test",loadOnStartup = 10)
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
static {
	System.out.println("loading of FirstServlet	.class file");
}
	public FirstServlet() {
		System.out.println("Instanstation object got created");
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("FirtServlet Started");
	PrintWriter out=response.getWriter();
	out.println("<h1> Request Processing :: GET METHOD </h1>");
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirtServlet Started");
		PrintWriter out=response.getWriter();
		out.println("<h1> Request Processing :: POST METHOD </h1>");
	}
}
