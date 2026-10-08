 package com.GetAttribute;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Attribute")
public class AttributeApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<body bgcolor='cyan'>");
		out.println("<table bgcolor='yellow' border='2' align='center'>");
		out.println("<tr> <th>ATTRIBUTENAME</th> <th>ATTRIBUTEVALUE</th> </tr> ");
		ServletContext context =getServletContext();
		
		context.setAttribute("NAME","PWSKILLS");
		context.setAttribute("TECH","EGTECH");
		context.setAttribute("LOCATION","NOIDA");
		context.setAttribute("COURSE","JAVA");
		//UPDATE LOCATION
		context.setAttribute("LOCATION","DELHI");
		//delete through course
		context.removeAttribute("COURSE");
		Enumeration<String> enu=context.getAttributeNames();
		while(enu.hasMoreElements()) {
			String attributename=(String)enu.nextElement();
			Object attributeValue=context.getAttribute(attributename);
			out.println("<tr>");
			out.println("<td>"+ attributename +"</td>");
			out.println("<td>"+ attributeValue +"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body>");
	}

}
