package com.demo.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.demo.spring.entity.Emp;

public class QueryAll {

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoConfig.class);
		JdbcTemplate jt = ctx.getBean(JdbcTemplate.class);

		List<Emp> empList = jt.query("select * from EMP", (rs, rowNum) -> {

			return new Emp(rs.getInt("EMPNO"), rs.getString("NAME"), rs.getString("ADDRESS"), rs.getDouble("SALARY"));
		});

		empList.stream().filter(e -> e.getSalary() > 50000).forEach(e -> System.out.println(e.getName()));

		Emp e = jt.queryForObject("select * from EMP where empno=" + 104, (rs, rowNum) -> {

			return new Emp(rs.getInt("EMPNO"), rs.getString("NAME"), rs.getString("ADDRESS"), rs.getDouble("SALARY"));
		});

		System.out.println(e.getName() + " " + e.getCity());
	}
}
