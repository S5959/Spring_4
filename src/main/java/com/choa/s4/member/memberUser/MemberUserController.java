package com.choa.s4.member.memberUser;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.choa.s4.member.MemberDTO;
import com.choa.s4.member.memberFile.MemberFileDTO;

@Controller
@RequestMapping(value="/member/**")
public class MemberUserController {
	
	@Autowired
	private MemberUserService memberUserService;
	
	//idCheck
	@PostMapping("memberIdCheck")
	public ModelAndView getMemberIdCheck(MemberDTO memberDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		long result = memberUserService.getMemberIdCheck(memberDTO);
				
		System.out.println("result " + result);
		mv.addObject("msg", result);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}
	
	//join
	@GetMapping("memberJoin")
	public ModelAndView setMemberJoin() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberJoin");
		
		return mv;
	}
	
	@PostMapping("memberJoin")
	public ModelAndView setMemberJoin(MemberDTO memberDTO, MultipartFile photo, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		System.out.println(photo.getOriginalFilename());
		System.out.println(photo.getName());
		System.out.println(photo.getSize());
		System.out.println(photo.getContentType());
		//byte[] ar = photo.getBytes();
		
		int result = memberUserService.setMemberJoin(memberDTO,photo, session);
		
		mv.setViewName("redirect:../");
		
		return mv;
	}

	
	//getMemberPage
	@GetMapping("memberPage")
	public ModelAndView getMemberPage() throws Exception {
		ModelAndView mv = new ModelAndView();
		/*
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");		
		MemberFileDTO memberFileDTO = memberUserService.getOne(memberDTO);
		
		mv.addObject("file", memberFileDTO);
		*/
		mv.setViewName("member/memberPage");
		return mv;
	}	

	
	//getMemberLogin
	@GetMapping("memberLogin")
	public ModelAndView getMemberLogin() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberLogin");
		
		return mv;
	}
		
	@PostMapping("memberLogin")
	public ModelAndView getMemberLogin(MemberDTO memberDTO, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("Login ID : " + memberDTO.getId());
		System.out.println("Login PW : " + memberDTO.getPw());
		memberDTO = memberUserService.getMemberLogin(memberDTO);
		
		if(memberDTO != null) {
			//index 페이지 이동
			//redirect

			System.out.println("--------------------------" + memberDTO.getMemberFileDTO());
			session.setAttribute("member", memberDTO);
			mv.setViewName("redirect:../");
		} else {
			//로그인 실패 메세지를 alert
			//로그인 입력 폼으로 이동
			//foward
			mv.addObject("msg", "Login Fail");
			mv.addObject("path", "./memberLogin");
			mv.setViewName("common/result");
		}
		
		return mv;
	}
	
	//getMemberLogout
	@GetMapping("memberLogout")
	public ModelAndView getMemberLogout(HttpSession session) throws Exception {
		//--로그아웃되는 조건--
		//웹브라우저를 종료
		//일정시간 경과 (로그인 후에 요청이 발생하면 시간이 연장)
		//meberDTO를 Null로 대체
		//유지시간을 강제로 0으로 변경
		session.invalidate();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:../");
		
		return mv;
	}
	
	//setMemberDelete 
	@GetMapping("memberDelete")
	public ModelAndView setMemberDelete(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		int result = memberUserService.setMemberDelete(memberDTO);
		
		mv.setViewName("redirect:../");
		session.invalidate();
		
		return mv;
	}
	
	//setMemberUpdate
	@GetMapping("memberUpdate")
	public ModelAndView setMemberUpdate(MemberDTO memberDTO) throws Exception {
		ModelAndView mv = new ModelAndView();		
		mv.setViewName("member/memberUpdate");		
		return mv;
	}
	
	@PostMapping("memberUpdate")
	public ModelAndView setMemberUpdate(MemberDTO memberDTO, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		MemberDTO s = (MemberDTO)session.getAttribute("member");
		memberDTO.setId(s.getId());
		
		int result = memberUserService.setMemberUpdate(memberDTO);
		
		if(result > 0) {
			s.setName(memberDTO.getName());
			s.setEmail(memberDTO.getEmail());
			session.setAttribute("member", s);
		}
		
		mv.setViewName("redirect:./memberPage");
		
		return mv;
	}
}
