package com.example.tuan05ontap.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.TextMessage;

@Component
public class SubcriberListener {
    @JmsListener(destination = "text-topic",containerFactory = "defaultJmsListenerContainerFactory")
    public void receiveText(TextMessage message) {
        System.out.println("Text message: ");
        System.out.println("Text message: " + message);
    }
}
