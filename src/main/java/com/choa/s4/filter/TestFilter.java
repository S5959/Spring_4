package com.choa.s4.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class TestFilter
 */

public class TestFilter implements Filter {

	/**
     * Default constructor. 
     */
	public TestFilter() { }
	

	//필터 인스턴스 초기화
	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException { }

	//전,후처리
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//place your code here
		//pass the request along the filter chain
		
		//qna 로그인한 사람만 접근 가능
		HttpServletRequest req = (HttpServletRequest)request;
		
		String url = req.getRequestURL().toString();
		String uri = req.getRequestURI();
		String result = uri.substring(uri.lastIndexOf("/")+1);
		
		System.out.println("URL : " + url);
		System.out.println("URI : " + uri);
		System.out.println("Result : " + result);
		
		
		HttpSession session = req.getSession();
		
		Object obj = session.getAttribute("member");
		
		System.out.println("session : " + session);
		System.out.println("obj : " + obj);
		
		if(result.equals("qnaList") && obj != null) {
			chain.doFilter(request, response);
		} else {
			((HttpServletResponse)response).sendRedirect("../member/memberLogin");
		}
	}

	//필터 인스턴스 종료
	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy() { }

}
