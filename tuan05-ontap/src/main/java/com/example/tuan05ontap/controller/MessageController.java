package com.example.tuan05ontap.controller;

import com.example.tuan05ontap.listener.Publisher;
import com.example.tuan05ontap.model.Message;
import com.example.tuan05ontap.model.User;
import com.example.tuan05ontap.service.JwtService;
import com.example.tuan05ontap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MessageController {
    @Autowired
    private  Publisher publisher;
    @Autowired
    private  UserService userService;
    @Autowired
    private  JwtService jwtService;

//    @Autowired
//    public MessageController(Publisher publisher, UserService userService, JwtService jwtService) {
//        this.publisher = publisher;
//        this.userService = userService;
//        this.jwtService = jwtService;
//    }

    @PostMapping("messages")
    public Message sendMessage(@RequestBody Message message) {
        publisher.sendMessage(message.getReceiver(), message.getMessage());
        return message;
    }

    @PostMapping("login")
    public Map<String,String> login(@RequestParam(name = "name") String name, @RequestParam(name = "password") String password) throws Exception {
        User user=userService.findByName(name);
        if(user!= null){
            if(user.getPassword().equals(password)){
                String token= jwtService.generateToken(user);
                HashMap<String,String> json= new HashMap<>();
                json.put("token", token);
                return json;
            }
            throw new Exception("Invalid password");
        }
        throw new Exception("Account invalid");
    }
}
