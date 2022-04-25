package com.example.fullstackprojekt.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class WishList {
    private int id;
    private String name;
    private String description;
    private int userId;
    private int ownerId;
    private List<Wish> wishes;


    public WishList(int id, String name, String description, List<Wish> wishes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.wishes = wishes;
    }

    public WishList(int id, String name, String description, int userId, int ownerId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.userId = userId;
        this.ownerId = ownerId;
    }
}