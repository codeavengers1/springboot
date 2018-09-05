package com.demo.spring;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.spring.entity.Emp;

//@Component
public class DemoRunner implements CommandLineRunner {

	@PersistenceContext
	EntityManager em;

	@Override
	public void run(String... args) throws Exception {
	List<Emp> empList=em.createQuery("select e from Emp e").getResultList();
	
	empList.stream().forEach(e->System.out.println(e.getEmpId()+" "+e.getName()+" "+e.getSalary()));

	}

}
