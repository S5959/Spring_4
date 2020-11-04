package com.choa.s4.exception;

import java.sql.SQLDataException;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(NullPointerException.class)
	public ModelAndView ex1() {
		ModelAndView mv = new ModelAndView();
		System.out.println("Null Point Exception");
		mv.setViewName("error/error_back");
		return mv;
	}
	
	@ExceptionHandler(SQLException.class)
	public ModelAndView ex2() {
		ModelAndView mv = new ModelAndView();
		System.out.println("SQL Exception");
		mv.setViewName("error/error_back");
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView ex3() {
		ModelAndView mv = new ModelAndView();
		System.out.println("Exception");
		mv.setViewName("error/error_back");
		return mv;
	}
}
