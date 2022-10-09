package com.example.tuan05ontap.service;

import com.example.tuan05ontap.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private List<User> users;

    public User findByName(String name) {
        for (User u : users) {
            if (u.getName().equals(name)){
                return u;
            }
        }
        return null;
    }


}
