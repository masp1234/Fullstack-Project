package com.example.fullstackprojekt.controllers;

import com.example.fullstackprojekt.models.User;
import com.example.fullstackprojekt.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

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

    @PostMapping("/share-wishlist")
    public String shareWishlist(@RequestParam("email") String email, HttpSession session,Model model){
        // Vi har allerede gemt id som session, når man klikker ind på wishlist
        User user = (User) session.getAttribute("user");
        int wishlistId = (int) session.getAttribute("wishlistSavedId");
        boolean canBeShared = userService.shareWishlist(email,wishlistId, user);
        model.addAttribute("canBeShared", canBeShared);
        return "redirect:/wishlist/" + wishlistId;
    }


    @PostMapping("/login-attempt")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session){
        boolean logInSuccessful = userService.login(email,password);
        if(logInSuccessful){
            session.setAttribute("user", userService.getCurrentUser());

            return "redirect:/bruger-forside";
        } else{
            model.addAttribute("loginFailed","loginFailed");
            return "redirect:/";
        }

    }

}
