package com.compney.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.compney.DemoLitner.DemoListner;

@WebServlet("/attribute")
public class RequestAttributeServletApp extends HttpServlet{
	private static final long serialVersionUID = 1L;
       static {
    	   System.out.println("RequestAttributeServletApp Loading ::enclosing_method");
       }
    public RequestAttributeServletApp() {
       System.out.println("RequestAttributeServletApp Instantation :: RequestAttributeServletApp");
    }
    @Override
    public void init() throws ServletException {
    	System.out.println("RequestAttributeServletApp.init()");
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		request.setAttribute("Lovedeep", "Choudhary");
		request.setAttribute("IPL", "16");
		request.setAttribute("Sohan", "kjbzf");
		request.removeAttribute("Sohan");
		request.setAttribute("IPL", "CSK");
		out.println("<body bgcolor='pink'>");
		out.println("<h1 style='color:green; text-align:center;'>");
		out.println("Attribute has been done");
		out.println("</h1>");
		out.println("</body>");
	}
	@Override
	public void destroy() {
		System.out.println("RequestAttributeServletApp.destroy()");
	}

}
