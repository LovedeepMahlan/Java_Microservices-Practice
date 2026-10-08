package com.FilterDespacher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     static {
    	 System.out.println("TargetServlet.class Loading");
     }
    public TargetServlet() {
       System.out.println("TargetSservlet.instantation");
    }
@Override
public void init() throws ServletException {
	System.out.println("TargetSservlet initilazation");
}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TargetServlet ::Processing");
		PrintWriter out=response.getWriter();
		out.println("<h1 style='color:red;text-align:center;'>Target form information</h1>");
		
	}

}
