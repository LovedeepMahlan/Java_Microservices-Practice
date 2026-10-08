package com.FilterDespacher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ForwardDespacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static {
    	System.out.println("ForwardDespacher.class() loading");
    }
    public ForwardDespacher() {
        System.out.println("ForwardDespacher.ForwardDespacher() instantiation");
    }
    @Override
    public void init() throws ServletException {
    	System.out.println("ForwardDespacher.init() initialization");
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ForwardDespacher.doGet() ::request Processing");
		PrintWriter out=response.getWriter();
		out.println("<h1 style=color:green; text-align:center;'>ForardDespacher form information</h1>");
		RequestDispatcher rw=request.getRequestDispatcher("./test2");
		rw.include(request, response);
	}

}
