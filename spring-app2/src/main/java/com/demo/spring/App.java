package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		HrService hr=(HrService)ctx.getBean("hr");
		
		System.out.println(hr.registerEmployee(100, "A", "B", 98000));

	}

}
