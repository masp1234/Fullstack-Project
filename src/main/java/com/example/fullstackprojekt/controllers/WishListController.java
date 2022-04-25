package com.example.fullstackprojekt.controllers;

import com.example.fullstackprojekt.models.User;
import com.example.fullstackprojekt.models.Wish;
import com.example.fullstackprojekt.models.WishStub;
import com.example.fullstackprojekt.services.WishListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class WishListController {

    private WishListService wishListService;

    public WishListController(WishListService wishListService) {
        this.wishListService = wishListService;
    }
    @GetMapping("/wishlist/{id}")
    public String getWishlistById(@PathVariable("id") int id, Model model) {
        List<Wish> wishes = WishStub.getAllWishesByWishList();
        model.addAttribute("wishlist", wishes);

        return "my-wishlist";

    }
    @GetMapping("/bruger-forside")
    public String brugerForside(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        model.addAttribute("wishLists", wishListService.getAllByUserId(user.getId()));
        return "bruger-forside";
    }
}
