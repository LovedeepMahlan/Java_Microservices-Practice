package com.RequestDespacher;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "Getting request from one servlet to another", urlPatterns={"/Second"})
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("REquest Processing");
		System.out.println("Second servlet request object ::"+request.getClass().hashCode());
		System.out.println("Second servlet response hashcode ::"+response.getClass().hashCode());
		PrintWriter out=response.getWriter();
		out.println("<body style='text-align: center; color: pink;'>");
        out.println("<h1 style='text-align: center; color: Green;'>Request from second servlet</h1>");
        out.println("<table border='2' align='center' style='border-color: cyan;'>");		
        out.println("<tr> <th> Parameter Name </th> <th> Parameter value </th> </tr>");
		Enumeration<String> enu=request.getAttributeNames();
		while(enu.hasMoreElements()) {
			out.println("<tr>");
			String ParameterName=(String)enu.nextElement();
			Object ParameterValue=request.getAttribute(ParameterName);
			out.println("<td>"+ParameterName+"</td>");
			out.println("<td>"+ParameterValue+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.close();
	}

}
