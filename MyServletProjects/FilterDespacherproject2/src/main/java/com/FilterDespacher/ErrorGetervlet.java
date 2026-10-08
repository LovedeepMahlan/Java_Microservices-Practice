package com.FilterDespacher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorGetervlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static {
    	System.out.println("ErrorGetervlet.class() Loading");
    }
    public ErrorGetervlet() {
       System.out.println("ErrorGetervlet.class() Instantation");
    }
    @Override
    public void init() throws ServletException {
    	System.out.println("ErrorGetervlet.init()");
    }

	@Override
	public void destroy() {
		System.out.println("ErrorGetervlet.destroy()");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ErrorGetervlet.doGet() :: RequestProcessing");
		System.out.println(10/0);
	}

}
