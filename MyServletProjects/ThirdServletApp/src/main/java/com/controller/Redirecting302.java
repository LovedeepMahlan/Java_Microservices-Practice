package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "Make  a redirect from sunms to oracle", urlPatterns = { "/SUNMS" })
public class Redirecting302 extends HttpServlet {
	private static final long serialVersionUID = 1L;
      static {
    	  System.out.println("sunms.class is loading");
      }
    public Redirecting302() {
    System.out.println("sunms.class is Initialization");    
    }
    @Override
    public void init() throws ServletException {
    	System.out.println("sunms.class is Instantation");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get requesting is processing");
		//we cal write it in two ways either this or 
		response.setStatus(302);
		response.setHeader("Location", "./oracle");
		// this
		//response.sendRedirect("./oracle");
	}

}
