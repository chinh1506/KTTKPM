package com.example.activemq.subscribertuan02.controller;

import com.example.activemq.subscribertuan02.listener.SubscriberListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class SubscriberController {
    @Autowired
    @Qualifier("objectMapMessage")
    private Map<Long,Object> messages;

    @Autowired
    private SubscriberListener listener;

    @GetMapping("/")
    public String showHome(Model model){
        model.addAttribute("messages", messages);
        return "index";
    }

}
