package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
public class EmpDbServiceMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpDbServiceMvcApplication.class, args);
	}

	@Bean
	public InternalResourceViewResolver vr() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/pages/");
		vr.setSuffix(".jsp");
		return vr;
	}
}
