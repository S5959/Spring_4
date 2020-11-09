package com.choa.s4.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/error/**")
public class ErrorFrontController {
	
	@GetMapping("error404")
	public ModelAndView error404() throws Exception {
		System.out.println("404");
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("msg", "존재하지 않는 페이지 입니다.");
		mv.setViewName("error/error_front");
		
		return mv;
	}
	
	@GetMapping("error405")
	public ModelAndView error405() throws Exception {
		System.out.println("405");
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("msg", "요청하신 페이지가 존재하지 않습니다.");
		mv.setViewName("error/error_front");
		
		return mv;
	}
	
	@GetMapping("error403")
	public ModelAndView error403() throws Exception {
		System.out.println("403");
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("msg", "권한이 없습니다.");
		mv.setViewName("error/error_front");
		
		return mv;
	}
}