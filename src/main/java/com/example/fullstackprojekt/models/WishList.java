package com.example.fullstackprojekt.models;

import java.util.List;

public class WishList {
    private int wishListId;
    private String name;
    private String description;
    private int userId;
    private int ownerId;
    private List<Wish> wishes;


    public WishList(int wishListId, String name, String description, List<Wish> wishes) {
        this.wishListId = wishListId;
        this.name = name;
        this.description = description;
        this.wishes = wishes;
    }

    public WishList(int wishListId, String name, String description, int userId, int ownerId) {
        this.wishListId = wishListId;
        this.name = name;
        this.description = description;
        this.userId = userId;
        this.ownerId = ownerId;
    }

    public WishList(String name, String description, int userId) {
        this.name= name;
        this.description= description;
        this.userId= userId;
    }

    public WishList(String name, String description) {
        this.name=name;
        this.description=description;
    }

    public WishList(int wishListId, String name, String description) {
        this.wishListId=wishListId;
        this.name=name;
        this.description=description;
    }

    public int getId() {
        return wishListId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public int getUserId() {
        return userId;
    }

    public List<Wish> getWishes() {
        return wishes;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "WishList{" +
                "id=" + wishListId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", userId=" + userId +
                ", ownerId=" + ownerId +
                ", wishes=" + wishes +
                '}';
    }
}