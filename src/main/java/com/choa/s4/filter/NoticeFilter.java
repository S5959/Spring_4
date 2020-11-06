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

import com.choa.s4.member.MemberDTO;

public class NoticeFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// noticeList, noticeSelect 누구나 접근 가능
		// write, update, delete 로그인 한 사람 중 id 가 admin만 가능

		
		HttpServletRequest req = (HttpServletRequest)request;
		String list = req.getRequestURI();
		list = list.substring(list.lastIndexOf("/")+1);
		
		//noticeList, noticeSelect 확인
		boolean check = list.equals("noticeList");
		if(!check) {	//noticeList가 아닌 경우 true
			check = list.equals("noticeSelect");
		}
		
		HttpSession session = req.getSession();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		
		//로그인한 사람 중 id가 admin인지 확인
		boolean adminCheck = false;
		if(memberDTO != null && memberDTO.getId().equals("admin")) {
			adminCheck = true;
		}
		
		if(check || adminCheck) {	//noticeList, noticeSelect 페이지는 누구나 접근 가능(true) || admin일 경우 요청 페이지 접근 가능(true)
			chain.doFilter(request, response);
		} else {
			((HttpServletResponse)response).sendRedirect("../member/memberLogin");
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
