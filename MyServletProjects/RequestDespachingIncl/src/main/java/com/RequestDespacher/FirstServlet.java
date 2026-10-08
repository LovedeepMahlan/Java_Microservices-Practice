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
		//request objected will be transfered into new object and some added data also be in new object
		System.out.println("First servlet reqest object ::"+request.getClass().hashCode());
		//While dispatching the response object new object and the data also be transfered into new data
		
		System.out.println("First servlet response hashcode ::"+response.getClass().hashCode());
		System.out.println("Request Processing");
		PrintWriter out=response.getWriter();
		out.println("<h1 style='text-align: center; color: Green;'>Request from first servlet</h1>");
		request.setAttribute("Name", "Lovedeep");
		request.setAttribute("Age", "21");
		//out.flush(); after flush the printWriter object request will no be transfer from one servlet to another servlet;
		RequestDispatcher rd=request.getRequestDispatcher("./Second");
		rd.include(request, response);
		out.println("<h1 style='text-align: center; color: Green;'>again Request from first servlet</h1>");

		out.close();
	}

}
