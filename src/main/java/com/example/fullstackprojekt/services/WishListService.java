package com.example.fullstackprojekt.services;

import com.example.fullstackprojekt.models.Wish;
import com.example.fullstackprojekt.models.WishList;
import com.example.fullstackprojekt.repositories.WishListRepository;
import com.example.fullstackprojekt.repositories.WishRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListService {

    public WishListService(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    private WishListRepository wishListRepository;

    public List<WishList> getAllByUserId(int id) {
        return wishListRepository.getAllByUserId(id);

    }

    public void createWishList(WishList wishList) {
        wishListRepository.createWishList(wishList);
    }
}
