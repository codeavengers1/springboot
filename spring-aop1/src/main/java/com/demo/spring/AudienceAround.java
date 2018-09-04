package com.demo.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class AudienceAround {
	@Pointcut("execution(* com..spring.Perf*.perf*(..))")
	private void pcut() {
	}

	public void switchOffMobile() {
		System.out.println("2:Audience Switched off mobile..");
	}

	public void takeSeat() {
		System.out.println("2:Audience taking seats..");
	}

	public void applaud() {
		System.out.println("2:Well Done! Clap! Clap! Clap!..");
	}

	@Around("pcut()")
	public void invoke(ProceedingJoinPoint pjp) throws Throwable {
		takeSeat();
		switchOffMobile();
		pjp.proceed();
		applaud();
	}
}
