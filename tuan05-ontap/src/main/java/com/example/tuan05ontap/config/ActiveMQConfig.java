package com.example.tuan05ontap.config;

import com.example.tuan05ontap.model.User;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableJms
@ComponentScan(basePackages = "com.example")
public class ActiveMQConfig {
    @Value("${spring.activemq.broker-url}")
    private String BROKER_URL;
    @Value("${spring.activemq.user}")
    private String USER_NAME;
    @Value("${spring.activemq.password}")
    private String PASSWORD;

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        System.out.println(BROKER_URL);
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL(BROKER_URL);
        factory.setUserName(USER_NAME);
        factory.setPassword(PASSWORD);
        return factory;
    }

    @Bean
    public DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        defaultJmsListenerContainerFactory.setConnectionFactory(activeMQConnectionFactory());
        defaultJmsListenerContainerFactory.setConcurrency("3-10");
        defaultJmsListenerContainerFactory.setPubSubDomain(false);
        return defaultJmsListenerContainerFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(activeMQConnectionFactory());
        return jmsTemplate;
    }

    @Bean
    public MessageConverter messageConverter() {
        MappingJackson2MessageConverter messageConverter = new MappingJackson2MessageConverter();
        messageConverter.setTargetType(MessageType.TEXT);
        messageConverter.setTypeIdPropertyName("_type");
        return messageConverter;
    }

    @Bean
    public List<User> users(){
        List list= new ArrayList<>();
        list.add(new User("A1","Chinh","Chinh123"));
        list.add(new User("A3","Chinh1","Chinh123"));
        list.add(new User("A4","Chinh2","Chinh123"));
        list.add(new User("A5","Chinh3","Chinh123"));
        return list;
    }
}
