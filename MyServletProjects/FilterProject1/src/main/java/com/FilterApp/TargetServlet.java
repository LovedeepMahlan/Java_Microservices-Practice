package com.FilterApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      static {
        System.out.println("TargetServlet Loading");
      }
    public TargetServlet() {
    System.out.println("TargetServlet.class inistanttion");  
    }
    @Override
    public void init() throws ServletException {
    	System.out.println("TargetServlet.init()");
    }
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("requestProcessing TargetFilter");
		PrintWriter out=response.getWriter();
		out.println("<h1 style='color:green; text-align:center;'>Information of TestServletClass</h1>");
	}
	@Override
	public void destroy() {
		System.out.println("TragetServlet deinstantation");
	}

}
