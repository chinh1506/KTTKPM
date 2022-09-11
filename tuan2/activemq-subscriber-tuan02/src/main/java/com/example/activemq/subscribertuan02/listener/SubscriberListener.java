package com.example.activemq.subscribertuan02.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import java.util.Map;

@Component
public class SubscriberListener {
    @Autowired
    @Qualifier("objectMapMessage")
    private Map<Long,Object> messages;

    @JmsListener(destination ="text-topic")
    public void receiveText(TextMessage textMessage) throws JMSException {
        messages.put(System.currentTimeMillis(),textMessage.getText());

        System.out.println("Receive text message: " + textMessage.getText());
    }
}
