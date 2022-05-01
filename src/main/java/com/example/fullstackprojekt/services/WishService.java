package com.example.fullstackprojekt.services;

import com.example.fullstackprojekt.models.Wish;
import com.example.fullstackprojekt.models.WishList;
import com.example.fullstackprojekt.repositories.WishRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishService {
    private WishRepository wishRepository;
    private WishListService wishListService;

    public WishService(WishRepository wishRepository, WishListService wishListService) {
        this.wishRepository= wishRepository;
        this.wishListService = wishListService;
    }
    public void addWish(Wish wish){
        wishRepository.addWish(wish);
    }
    public void updateByid(Wish wish){
        wishRepository.updateByid(wish);
    }
    public void deleteById(int id){
        wishRepository.deleteById(id);
    }

    public List<Wish> getAllWishesByWishListId(int id) {
        return wishRepository.findListById(id);

    }

    public Wish selectWishById(int id) {
        return wishRepository.selectWishById(id);

    }

    public WishList getWishlistById(int id) {
        return wishListService.findListById(id);
    }

    public void reserveWish(int id) {
        Wish wish = wishRepository.selectWishById(id);
        int isReserved = -1;
        if (wish.isReserved() == true) {
            isReserved = 0;
        }
        else {
            isReserved = 1;
        }

        wishRepository.reserveWish(id, isReserved);
    }
}
