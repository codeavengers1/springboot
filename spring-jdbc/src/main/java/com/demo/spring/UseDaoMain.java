package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UseDaoMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoConfig.class);
		
		HrService service=ctx.getBean(HrService.class);
		
		System.out.println(service.register(107, "Arun", "Chennai", 76000));
		
		service
		.getEmpList()
		.stream()
		.forEach(e->System.out.println(e.getName()+" "+e.getCity()));
		
	}

}
