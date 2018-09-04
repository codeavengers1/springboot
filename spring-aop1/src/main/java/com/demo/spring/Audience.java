package com.demo.spring;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class Audience {
	@Pointcut("execution(* com..spring.Sing*.perf*(..))")
	private void pcut() {}

	@Before("pcut()")
	public void switchOffMobile() {
		System.out.println("1:Audience Switched off mobile..");
	}

	@Before("pcut()")
	public void takeSeat() {
		System.out.println("1:Audience taking seats..");
	}

	@AfterReturning("pcut()")
	public void applaud() {
		System.out.println("1:Well Done! Clap! Clap! Clap!..");
	}
}
