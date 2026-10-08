package com.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cookie2")
public class CookieApp2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Cookie[] c1=request.getCookies();
		if(c1==null) {
			out.println("<h1 style='color:red; text-align:center;>Cookie is null No data found</h1>");
		}else {
			out.println("<h1 style=\"color: yellow; text-align: center;\">COOKIE INFORMATION</h1>");
			out.println("<table align='center' boredr=1>");
			out.println("<tr> <th> COOKIE NAME </th> <th> COOKIE VALUE </th> <tr>");
			for(Cookie cook:c1) {
				out.println("<tr>");
				String name=cook.getName();
				String value=cook.getValue();
				out.println("<td>"+name+"</td>");
				out.println("<td>"+value+"</td>");
				out.println("</tr");
			}
			out.println("</table");
			out.println("/body");
			
		}
		out.close();
	}

}
