package com.example.fullstackprojekt.controllers;

import com.example.fullstackprojekt.models.Wish;
import com.example.fullstackprojekt.models.WishStub;
import com.example.fullstackprojekt.repositories.WishRepository;
import com.example.fullstackprojekt.services.WishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WishController {
   WishService wishService;
   WishRepository wishRepository;

    public WishController(WishService wishService) {
        this.wishService = wishService;
    }

    @GetMapping("/bruger-forside/{id}")
    public String brugerForside(@PathVariable("id") int id, Model model){
        model.addAttribute("findUserById", wishRepository.findListById(id));
        return "bruger-forside";
    }
    @GetMapping("/wishlist/{id}")
    public String getAllWishesByWishListId(@PathVariable("id") int id, Model model) {
        List<Wish> wishes = wishService.getAllWishesByWishListId(id);
        model.addAttribute("wishlist", wishes);
        return "my-wishlist";
    }


    @GetMapping("/add")
    public String showAddWish(){
        return "add";
    }


    @PostMapping( value = "add")
    public String addWish(@RequestParam("name") String name,
                          @RequestParam("description") String description,
                          @RequestParam("price") int price,
                          @RequestParam("link") String link){
        wishService.addWish(new Wish(name, description, price, link));
        return "redirect:/bruger-forside";
    }

    @GetMapping("update/{id}")
    public String showupdateside(@PathVariable("id") int id, Model model){
        model.addAttribute("findWishById", wishRepository.findWishById(id));
        return "update";
    }


    @PostMapping( value = "update")
    public String updateWish(@RequestParam("name") String name,
                          @RequestParam("description") String description,
                          @RequestParam("price") int price,
                          @RequestParam("link") String link){
        wishService.updateByid(new Wish(name, description, price, link));
        return "redirect:/bruger-forside";
    }


    @GetMapping("delete/{id}")
    public String deleteWish(@PathVariable("id") int id){
      wishService.deleteById(id);
        return "redirect:/bruger-forside";
    }
}
