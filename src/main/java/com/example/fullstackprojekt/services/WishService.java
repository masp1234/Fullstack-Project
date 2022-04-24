package com.example.fullstackprojekt.services;

import com.example.fullstackprojekt.models.Wish;
import com.example.fullstackprojekt.repositories.WishRepository;
import org.springframework.stereotype.Service;

@Service
public class WishService {
    private Wish currentWish= null;
    private WishRepository wishRepository;

    public WishService(WishRepository wishRepository) {
        this.wishRepository= wishRepository;
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

}
