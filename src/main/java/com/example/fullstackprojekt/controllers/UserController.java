package com.example.fullstackprojekt.controllers;

import com.example.fullstackprojekt.services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }




}
