package com.GetAttribute;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HitCountApp
 */
@WebServlet("/HitCount")
public class HitCountApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
	ServletContext context =getServletContext();
	Integer value=(Integer)context.getAttribute("hitcount");
	if(value==null) {
		value=1;
	}else {
		value++;
	}
	context.setAttribute("hitcount", value);
	out.println("<body bgcolor='cyan'>");
	out.println("<h1 color ='red'>Total numer of hitcount is :: "+value+"</h1>");
	out.println("</body>");
	out.close();
	}

}
