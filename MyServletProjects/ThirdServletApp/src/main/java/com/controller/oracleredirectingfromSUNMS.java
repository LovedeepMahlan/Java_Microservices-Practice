package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Redirecting302
 */
@WebServlet(description = "Make  a redirect from sunms to oracle", urlPatterns = { "/oracle" })
public class oracleredirectingfromSUNMS extends HttpServlet {
	private static final long serialVersionUID = 1L;
      static {
    	  System.out.println("oracle.class is loading");
      }
    public oracleredirectingfromSUNMS() {
    System.out.println("oracle.class is Initialization");    
    }
    @Override
    public void init() throws ServletException {
    	System.out.println("oracle.class is Instantation");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get requesting is processing for oracle");
		PrintWriter out=response.getWriter();
		out.println("<h1>Welcome in oracle indexing page</h1>");
		out.close();
	}

}
