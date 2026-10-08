package com.GetAttribute;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ToGetSession")
public class ToGetSessionApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =request.getSession();
		Integer value=(Integer)session.getAttribute("hitcount");
		if(session.isNew()) {
			if(value==null) {
				value=1;
			}else {
				value++;
			}
		}
		session.setAttribute("hitcount", value);
		PrintWriter out=response.getWriter();
		out.println("<body bgcolor='cyan'>");
		out.println("<h1 color ='red'>Total numer of  session is :: "+value+"</h1>");
		out.println("</body>");
		out.close();
		
	}

}
