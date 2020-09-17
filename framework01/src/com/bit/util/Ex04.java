package com.bit.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class Ex04
 */
@WebFilter("/ex01")
public class Ex04 implements Filter {


	public void destroy() {

		System.out.println("ex04 destroy~~");
	
	
	
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("ex04 doFilter~~");
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("ex04 initFilter~~");

	
	
	}

}
