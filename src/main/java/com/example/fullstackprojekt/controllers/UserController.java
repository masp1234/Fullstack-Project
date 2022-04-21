package com.example.fullstackprojekt.controllers;

import com.example.fullstackprojekt.models.User;
import com.example.fullstackprojekt.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value ="/sign_Up")
    public String createUser(@ModelAttribute User user) {
        //Opretter user
        userService.createUser(user);

        return "redirect:/bruger-forside";
    }
}
