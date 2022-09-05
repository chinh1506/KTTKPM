package com.example.messagequeuetuan02.controller;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.messagequeuetuan02.listener.ListenMessage;

@Controller
public class ChatController {
	@Autowired
	private ListenMessage listener;

	
	@GetMapping("/")
	public String sendMessage(Model model) throws JMSException {
//		String mess= listener.receiveMessage(null);
		return "index";
	}

	@PostMapping("/sender")
	public String sendMessage(Model model, @RequestParam String message) throws Exception {
		System.out.println(message);
		listener.sendMessage("chinh", message);
		return "index";
	}
}
