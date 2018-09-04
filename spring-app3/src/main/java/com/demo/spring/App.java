package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		HrService hr=(HrService)ctx.getBean("hrService");
		
		System.out.println(hr.registerEmployee(100, "A", "B", 98000));

	}

}
