package com.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieApp1
 */
@WebServlet("/Cookie1")
public class CookieApp1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String value=request.getParameter("value");
		Cookie cook=new Cookie(name,value);
		cook.setMaxAge(30);
		response.addCookie(cook);
		out.println("<h1 style='color:red; text-align:center;>Cookie Created Succesfully</h1>");
		RequestDispatcher rd=request.getRequestDispatcher("./index.html");
		rd.forward(request, response);
	}

}
