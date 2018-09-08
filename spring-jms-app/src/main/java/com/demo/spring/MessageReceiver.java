package com.demo.spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class MessageReceiver {

	public static void main(String[] args) throws JMSException {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JmsConfig.class);
		JmsTemplate jt = ctx.getBean(JmsTemplate.class);

		Message message = jt.receive("testQueue");
		TextMessage tm = (TextMessage) message;
		System.out.println(tm.getText());

	}

}
