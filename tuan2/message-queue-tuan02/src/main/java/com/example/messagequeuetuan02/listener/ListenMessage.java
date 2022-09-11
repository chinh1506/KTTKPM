package com.example.messagequeuetuan02.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Component
public class ListenMessage {
	@Autowired
	private JmsTemplate jmsTemplate;

	public void sendMessage(String queueName, final String message) {
//        Map map = new Gson().fromJson(message, Map.class);
//        final String textMessage = "Chào nhé " + map.get("name");
		System.out.println("Gửi tin nhắn " + message + " đến queue - " + queueName);
		jmsTemplate.send(queueName, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(message);
			}
		});
	}

	@JmsListener(destination = "mailbox", containerFactory = "jmsListenerContainerFactory")
	public void receiveMessage(final String email) {
		System.out.println("Received <" + email + ">");
	}
}
