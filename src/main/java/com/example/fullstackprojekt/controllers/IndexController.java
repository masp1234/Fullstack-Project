package com.example.fullstackprojekt.controllers;

import com.example.fullstackprojekt.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index.html";
    }

    @GetMapping("/login")
    public String login(){
        return "login.html";
    }

    @GetMapping("/signUp")
    public String signUp(){
        return "signUp.html";
    }

    @GetMapping("/footer")
    public String footer() {
        return "footer";
    }
}
