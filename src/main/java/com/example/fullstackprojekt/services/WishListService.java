package com.example.fullstackprojekt.services;

import com.example.fullstackprojekt.models.Wish;
import com.example.fullstackprojekt.models.WishList;
import com.example.fullstackprojekt.repositories.WishListRepository;
import com.example.fullstackprojekt.repositories.WishRepository;
import org.springframework.stereotype.Service;

@Service
public class WishListService {
    private WishList currentWish= null;
    private WishListRepository wishListRepository;

}
