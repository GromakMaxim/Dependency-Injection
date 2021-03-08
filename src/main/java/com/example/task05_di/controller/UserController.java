package com.example.task05_di.controller;

import com.example.task05_di.model.User;
import com.example.task05_di.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void save(User user) {
        userService.save(user);
    }

    public String show() {
        return userService.show();
    }

    public void deleteItem(int id) {
        userService.deleteItem(id);
    }

    public User getById(int id) {
        return userService.getById(id);
    }
}
