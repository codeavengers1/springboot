package com.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	public ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.description("My Sample Emp Service")
				.license("AS You Wish License").
				title("My Swagger API Doc").build();
	
	}
	
	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select().apis(RequestHandlerSelectors.basePackage("com.demo.spring"))
				.paths(PathSelectors.any())
				.build().apiInfo(apiInfo());
	}
	
}
