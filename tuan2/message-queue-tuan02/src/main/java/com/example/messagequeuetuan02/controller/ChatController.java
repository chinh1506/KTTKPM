package com.example.messagequeuetuan02.controller;

import javax.jms.JMSException;

import com.example.messagequeuetuan02.service.PublisherPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.messagequeuetuan02.listener.ListenMessage;

import java.util.Map;

@Controller
public class ChatController {

	@Autowired
	private PublisherPersonService personService;
	@Autowired
	@Qualifier("objectMapMessage")
	private Map<Long, Object> mapMessage;
	@GetMapping("/")
	public String openHome(Model model) {
		model.addAttribute("messages",mapMessage);
		return "index";
	}

	@PostMapping("/publish")
	public String sendMessage(Model model, @RequestParam String message) throws Exception {
		System.out.println(message);
		personService.publishText(message);
		System.out.println("list message: "+mapMessage);
		return "redirect:/";
	}
}
