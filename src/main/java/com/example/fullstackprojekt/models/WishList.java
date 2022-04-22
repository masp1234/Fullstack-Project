package com.example.fullstackprojekt.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class WishList {
    int id;
    String name;
    String description;
    List<Wish> wishList;


    public WishList(int id, String name, String description, List<Wish> wishList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.wishList = wishList;
    }
}
