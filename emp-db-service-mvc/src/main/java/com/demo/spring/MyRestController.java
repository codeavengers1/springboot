package com.demo.spring;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

	@RequestMapping(path="/greet/{name}")
	public String greet(@PathVariable("name") String name) {
		return "Wecome to Spring REST, " + name;
	}
}
