package com.compney.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.compney.DemoLitner.DemoListner;

/**
 * Servlet implementation class TargetServlet
 */
@WebServlet("/test")
public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       static {
    	   System.out.println("TargetServlet Loading  ::TargetServlet.class file is loading()");
       }
       
    public TargetServlet() {
      System.out.println("TargetServlet.TargetServlet() Instantation");
    }

		@Override
		public void init() throws ServletException {
			System.out.println("TargetServlet.init() Initialization");
		}
		@Override
		public void destroy() {
			System.out.println("TargetServlet.init() Initialization");
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Request Processing for TargetServlet get method");
		PrintWriter out=response.getWriter();
		out.println("<body bgcolor='pink'>");
		out.println("<h1 style='color:green; text-align:center;'>");
		out.println("No of object created at our servlet is "+DemoListner.count);
		out.println("</h1>");
		out.println("</body>");
	}

}
