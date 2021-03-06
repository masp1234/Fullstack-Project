package com.example.fullstackprojekt.services;

import com.example.fullstackprojekt.models.WishList;
import com.example.fullstackprojekt.repositories.WishListRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class WishListService {

    public WishListService(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    private WishListRepository wishListRepository;

    public List<WishList> getAllByUserId(int id) {
        List<WishList> myLists = wishListRepository.getAllWishlistByUserId(id);
        List<WishList> listsSharedWithMe = wishListRepository.getAllSharedLists(id);
        myLists.addAll(listsSharedWithMe);
        Collections.sort(myLists);
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
