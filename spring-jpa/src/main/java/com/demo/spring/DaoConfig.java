package com.demo.spring;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
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
	public HibernateJpaVendorAdapter va() {
		HibernateJpaVendorAdapter va = new HibernateJpaVendorAdapter();
		va.setDatabase(Database.MYSQL);
		va.setShowSql(true);
		return va;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setJpaVendorAdapter(va());
		emf.setPackagesToScan("com.demo.spring.entity");
		emf.setDataSource(ds());
		return emf;

	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {

		JpaTransactionManager txm = new JpaTransactionManager();
		txm.setEntityManagerFactory(emf);
		return txm;

	}

}
