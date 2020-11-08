package com.choa.s4.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class QnaMemberInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// qna는 회원가입한 사람만 접근 가능
		System.out.println("QnaMemberInterceptor");
		System.out.println("----------------------------");
		
		HttpSession session = request.getSession();
		
		Object obj = session.getAttribute("member");
		
		boolean check = false;
		if(obj != null) {
			check = true;
		} else {
			System.out.println("로그인이 안되어있음");
			response.sendRedirect("../member/memberLogin");
		}
		
		return check;
	}

}
