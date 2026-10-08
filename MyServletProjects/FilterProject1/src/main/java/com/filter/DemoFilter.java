package com.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;

public class DemoFilter extends HttpFilter implements Filter {
	
	private static final long serialVersionUID = 1L;

	static {
    	System.out.println("DEmoFilter class Loading");
    }
	public DemoFilter() {
        System.out.println("demo classs instantiation");
    }
	public void destroy() {
		System.out.println("DemoFilter Deinitiaalization");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
System.out.println("REQUEST PROCESSING :: DemoFilter.doFilter()");
		
		PrintWriter out = response.getWriter();
		out.println("<h1 style='color:red; text-align:center'>ADDED BY FILTER BEFORE PROCESSING REQUEST...</h1>");
		// pass the request along the filter chain
		chain.doFilter(request, response);
		out.println("<h1 style='color:red; text-align:center'>ADDED BY FILTER AFTER PROCESSING REQUEST...</h1>");	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("DEmo class initialisation");
	}
}
