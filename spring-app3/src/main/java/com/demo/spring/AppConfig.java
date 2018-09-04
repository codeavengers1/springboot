package com.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.demo.spring.dao.EmpDaoJdbcImpl;

@Configuration
@ComponentScan(basePackages = "com.demo.spring")
public class AppConfig {

	@Bean
	public EmpDaoJdbcImpl jdbcBean() {
		return new EmpDaoJdbcImpl();
	}

}
