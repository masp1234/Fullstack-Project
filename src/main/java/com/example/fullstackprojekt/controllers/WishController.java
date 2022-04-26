package com.example.fullstackprojekt.controllers;

import com.example.fullstackprojekt.models.User;
import com.example.fullstackprojekt.models.Wish;
import com.example.fullstackprojekt.repositories.WishRepository;
import com.example.fullstackprojekt.services.WishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
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
    public String getAllWishesByWishListId(@PathVariable("id") int id, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        session.setAttribute("wishlistSavedId", id);
        List<Wish> wishes = wishService.getAllWishesByWishListId(id);
        model.addAttribute("wishlist", wishes);
        return "my-wishlist";
    }

    @PostMapping("/add-wish")
    public String addWish(@RequestParam("name") String name,
                          @RequestParam("description") String description,
                          @RequestParam("price") int price,
                          @RequestParam("link") String link,
                          HttpSession session){

        // Tager wishlistId fra session, som er blevet oprettet når man klikker på en wishlist
        int wishListId = (int) session.getAttribute("wishlistSavedId");

        wishService.addWish(new Wish(name, description, price, link, wishListId));

        // Tager id fra session og tilføjer til URL
        return "redirect:/wishlist/" + session.getAttribute("wishlistSavedId");
    }



    @PostMapping("/update-wish")
    public String updateWish(@RequestParam("id") int id,
                             @RequestParam("name") String name,
                             @RequestParam("description") String description,
                             @RequestParam("price") int price,
                             @RequestParam("link") String link,
                             HttpSession session){

        wishService.updateByid(new Wish(id, name, description, price, link));
        return "redirect:/wishlist/" + session.getAttribute("wishlistSavedId");
    }


    @GetMapping("/delete/{id}")
    public String deleteWish(@PathVariable("id") int id, HttpSession session){
      wishService.deleteById(id);
        return "redirect:/wishlist/" + session.getAttribute("wishlistSavedId");
    }

    //TODO Spørg om hvorfor man ikke har pathen som "wishlist/11/wish/3" i stedet for en uafhængig side (ikke en underside)
    @GetMapping("/wishlist/update-wish/{id}")
    public String updateWishForm(@PathVariable("id") int id, Model model) {
        Wish wish = wishService.selectWishById(id);

        System.out.println(wish);
        model.addAttribute("wish", wish);
        return "update-wish";
    }
}
