package com.example.fullstackprojekt.services;

import com.example.fullstackprojekt.models.WishList;
import com.example.fullstackprojekt.repositories.WishListRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class WishListService {

    public WishListService(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    private WishListRepository wishListRepository;

    public List<WishList> getAllByUserId(int id) {
        List<WishList> myLists = wishListRepository.getAllByUserId(id);
        List<WishList> listsSharedWithMe = wishListRepository.getAllSharedLists(id);
        myLists.addAll(listsSharedWithMe);
        return myLists;

    }

    public void createWishList(WishList wishList) {
        wishListRepository.createWishList(wishList);
    }

    public void deleteById(int id) {
        wishListRepository.deleteById(id);
    }

    public WishList findListById(int id) {
        return wishListRepository.findWishListById(id);
    }

    public void updateListById(WishList wishList) {
        wishListRepository.updateByid(wishList);
    }
}
