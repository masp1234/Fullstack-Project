package com.example.fullstackprojekt.controllers;

import com.example.fullstackprojekt.models.Wish;
import com.example.fullstackprojekt.models.WishStub;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class WishListController {
    @GetMapping("/wishlist/{id}")
    public String getWishlistById(@PathVariable("id") int id, Model model) {
        List<Wish> wishes = WishStub.getAllWishesByWishList();
        model.addAttribute("wishlist", wishes);

        return "my-wishlist";

    }
}
