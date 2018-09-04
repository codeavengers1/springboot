package com.demo.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.entity.Emp;

public class UseDaoMainTx {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoConfig.class);
		
		HrService service=ctx.getBean(HrService.class);
		/*
		List<Emp> elist=new ArrayList<>();
		elist.add(new Emp(205, "Ramu", "Hyderabad", 67000));
		elist.add(new Emp(206, "Somnath", "Hyderabad", 76000));
		elist.add(new Emp(203, "Chethan", "Noida", 43000));
		elist.add(new Emp(207, "James", "Bangalore", 78000));
		
		service.saveEmpList(elist);*/
		
		System.out.println(service.removeEmp(104));
		
	}

}
