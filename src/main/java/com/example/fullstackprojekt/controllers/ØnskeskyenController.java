package com.example.fullstackprojekt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ØnskeskyenController {

    @GetMapping("/")
    public String index(){
        return "index.html";
    }

}
