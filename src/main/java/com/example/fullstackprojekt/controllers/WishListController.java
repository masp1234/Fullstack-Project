package com.example.fullstackprojekt.controllers;
import com.example.fullstackprojekt.models.User;
import com.example.fullstackprojekt.models.WishList;

import com.example.fullstackprojekt.repositories.WishListRepository;
import com.example.fullstackprojekt.services.WishListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;


@Controller
public class WishListController {

    private WishListService wishListService;



    public WishListController(WishListService wishListService) {
        this.wishListService = wishListService;
    }

    @GetMapping("/bruger-forside")
    public String brugerForside(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        model.addAttribute("wishLists", wishListService.getAllByUserId(user.getId()));
        return "bruger-forside";
    }

    @PostMapping("/add-wishlist")
    public String opretList(@RequestParam("wishlistName") String name,
                            @RequestParam("wishlistDescription") String description,
                             HttpSession httpSession){
         User user = (User) httpSession.getAttribute("user");
        wishListService.createWishList(new WishList(name,description, user.getId()));
        return "redirect:/bruger-forside";
    }
    @GetMapping("/updatelist/{id}")
    public String findListById(@PathVariable ("id") int id, Model model, HttpSession session){
        WishList wishList=(WishList) session.getAttribute("wishlist");
        model.addAttribute("wishlist", wishList);
        model.addAttribute("wishlist", wishListService.findListById(id));
        return "update-wishlist";
    }

    @PostMapping(value = "update-list")
    public String updateList(@RequestParam("wishlistName") String name,
                             @RequestParam("wishlistDescription") String description,
                             HttpSession session){
        wishListService.updateListById(new WishList(name,description));
        return "redirect:/bruger-forside";
    }
    @GetMapping("/deletelist/{id}")
    public String deleteListWish(@PathVariable("id") int id){
        wishListService.deleteById(id);
        return "redirect:/bruger-forside";
    }
}
