package com.demo.spring;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@EnableJms

public class JmsConfig {

	@Bean
	public ActiveMQConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
		cf.setBrokerURL("tcp://localhost:61616");
		return cf;
	}

	@Bean
	public JmsTemplate jmsTemplate() {
		JmsTemplate jt = new JmsTemplate();
		jt.setConnectionFactory(connectionFactory());
		jt.setDefaultDestinationName("testQueue");
		return jt;
	}
}
