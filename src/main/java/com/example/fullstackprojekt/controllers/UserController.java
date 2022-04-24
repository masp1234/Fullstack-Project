package com.example.fullstackprojekt.controllers;

import com.example.fullstackprojekt.models.User;
import com.example.fullstackprojekt.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }



    @PostMapping(value ="/sign-up")
    public String createUser(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
    @RequestParam("email") String email, @RequestParam("password") String password) {
        //Opretter user
        userService.createUser(new User(email,firstName,lastName,password));

        return "redirect:/";
    }


    @PostMapping("/login-attempt")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model){
        boolean logInSuccessful = userService.login(email,password);
        if(logInSuccessful){
            //User user = userService.sendUser();
            //model.addAttribute("user", user);
            return "redirect:/bruger-forside";
        } else{
            model.addAttribute("loginFailed","loginFailed");
            return "login";
        }

    }

}
