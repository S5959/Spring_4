package com.choa.s4.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EndingFilter implements Filter {

	private String encode;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//init - 초기화 메서드
		encode = filterConfig.getInitParameter("encode");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("Encoding Filter In");
		
		request.setCharacterEncoding(encode);
		response.setCharacterEncoding(encode);
		chain.doFilter(request, response);
		
		System.out.println("Encoding Filter Out");
	}

	@Override
	public void destroy() { }

}
