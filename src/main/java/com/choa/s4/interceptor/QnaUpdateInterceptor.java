package com.choa.s4.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.choa.s4.board.BoardDTO;
import com.choa.s4.member.MemberDTO;

@Component
public class QnaUpdateInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//로그인한 사용자 Id
		HttpSession session = request.getSession();
		
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		
		String id = memberDTO.getId();
		
		//글 작성자
		//BoardDTO boardDTO = modelAndView.getModel();	//return타입 Map<DataType, Key>?
		Map<String, Object> model = modelAndView.getModel();
		BoardDTO boardDTO = (BoardDTO)model.get("dto");
		String writer = boardDTO.getWriter();
		String board = (String)model.get("board");
		
		if(!id.equals(writer)) {
			modelAndView.addObject("msg", "작성자가 아님");
			modelAndView.addObject("path", board+"List");
		}
		super.postHandle(request, response, handler, modelAndView);
	}
}
