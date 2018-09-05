package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.spring.repo.EmpRepository;

@Component
public class RepoRunner implements CommandLineRunner {

	@Autowired
	EmpRepository repo;
	@Override
	public void run(String... args) throws Exception {
		
		repo.findAll().stream().forEach(e->System.out.println(
				e.getEmpId()+" "+e.getName()+" "+e.getSalary()));

	}

}
