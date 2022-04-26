package com.example.fullstackprojekt.controllers;

import com.example.fullstackprojekt.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {


    //TODO Lav også en log-out, der redirecter til index og sletter session
    @GetMapping("/")
    public String index(HttpSession session){
        String templateUrl = "index";
        if (session.getAttribute("user") != null) {

            //uden redirect henter den ikke ønskelister
            templateUrl = "redirect:/bruger-forside";
        }

        return templateUrl;
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

    @GetMapping("/create-wishlist")
    public String createlist(){
        return "create-wishlist";
    }
}
