package com.demo.spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class MessageSender {

	static int count = 0;

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JmsConfig.class);
		JmsTemplate jt = ctx.getBean(JmsTemplate.class);

		for (int i = 0; i < 10; i++) {

			jt.send(new MessageCreator() {

				@Override
				public Message createMessage(Session session) throws JMSException {
					TextMessage message = session.createTextMessage();
					message.setText("message " + count);
					return message;
				}
			});
			count++;
		}
		System.out.println("Messages Sent....");
	}

}
