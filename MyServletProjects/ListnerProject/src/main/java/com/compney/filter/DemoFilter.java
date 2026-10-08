package com.compney.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class DemoFilter
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, urlPatterns = { "/test" })
public class DemoFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;
	static {
		System.out.println("DemoFilter Loading :: DemoFilter.class file  is loading");
	}
    public DemoFilter() {
       System.out.println("DemoFilter Instantation");
    }
    
    public void destroy() {

    System.out.println("DemoFilter.destroy() DeInitilization");
    }

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("DemoFilter.doFilter() get method is in using");
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	System.out.println("DemoFilter.init() Initilization");
	}

}
