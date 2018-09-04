package com.demo.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

public class InsertDemo {

	public static void main(String[] args) {
		String INSERT_STMT = "insert into EMP (empno,name,address,salary) values(?,?,?,?)";

		ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoConfig.class);
		JdbcTemplate jt = ctx.getBean(JdbcTemplate.class);

		int count = jt.update(new PreparedStatementCreator() {

			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst = con.prepareStatement(INSERT_STMT);
				pst.setInt(1, 105);
				pst.setString(2, "Umakanth");
				pst.setString(3, "Bangalore");
				pst.setDouble(4, 56000);
				return pst;
			}
		});

		System.out.println("Rows Inserted : " + count);

	}

}
