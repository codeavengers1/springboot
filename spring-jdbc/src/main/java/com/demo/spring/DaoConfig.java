package com.demo.spring;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.demo.spring")
@EnableTransactionManagement
public class DaoConfig {

	@Bean
	public DriverManagerDataSource ds() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springdb?useSSL=false");
		ds.setUsername("root");
		ds.setPassword("root");// your password is 'admin'
		return ds;
	}

	@Bean
	public JdbcTemplate jt(DataSource ds) {
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(ds);
		return jt;
	}

	@Bean
	public DataSourceTransactionManager transactionManager(DataSource ds) {
		DataSourceTransactionManager txm = new DataSourceTransactionManager(ds);
		return txm;
	}
}
