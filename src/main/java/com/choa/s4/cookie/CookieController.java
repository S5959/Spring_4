package com.choa.s4.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cookie/**")
public class CookieController {
	
	@GetMapping("showCookie")
	public void showCooke(@CookieValue(value="name", required=false) Cookie cookie) throws Exception {
		System.out.println("Show Cookie");
		System.out.println(cookie.getName());
		System.out.println(cookie.getValue());
		
		/* 
		 * showCookie(HttpServletRequest request) 일 경우
		 * 
		Cookie[] cookies = request.getCookies();
		
		for(Cookie cookie: cookies) {
			System.out.println(cookie.getName());
			System.out.println(cookie.getValue());
			System.out.println("------------------");			
		}*/
	}
	
	@GetMapping("makeCookie")
	public ModelAndView makeCookie(HttpServletResponse reponse) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("Make Cookie");
		
		Cookie cookie = new Cookie("name","choa");
		cookie.setMaxAge(60);
		
		reponse.addCookie(cookie);
		
		return mv;
	}
}
