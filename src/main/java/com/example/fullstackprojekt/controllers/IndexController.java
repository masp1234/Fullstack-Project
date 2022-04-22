package com.example.fullstackprojekt.controllers;

import com.example.fullstackprojekt.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        UserRepository userRepository = new UserRepository();
        userRepository.selectUserById(1);
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
    @GetMapping("bruger-forside")
    public String brugerForside(){
        return "bruger-forside";
    }
    @GetMapping("/footer")
    public String footer() {
        return "footer";
    }
}
