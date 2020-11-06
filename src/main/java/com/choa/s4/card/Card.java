package com.choa.s4.card;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Card {
	
	@After("execution(* com.choa.s4.transfer.Taxi.get*())")
	public void cardCheck() {
		System.out.println("카드 찍기");
		System.out.println("------------");
	}
	
	@Around("execution(* com.choa.s4.transfer.*.take*(..))")
	public void transferCard(ProceedingJoinPoint join) {
		System.out.println("승차전 카드찍기");
		System.out.println("------------");
		
		Object obj = null;
		
		try {
			Object [] ar = join.getArgs();
			
			for(Object o:ar) {
				System.out.println(o);
			}
			obj = join.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		System.out.println("하차 후 카드 찍기");
	}
	
}
