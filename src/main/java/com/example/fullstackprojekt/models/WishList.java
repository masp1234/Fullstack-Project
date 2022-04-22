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
    private List<Wish> wishes;


    public WishList() {

    }

    public WishList(int id, String name, String description, List<Wish> wishes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.wishes = wishes;
    }
}