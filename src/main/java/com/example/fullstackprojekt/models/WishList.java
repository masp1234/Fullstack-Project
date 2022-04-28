package com.example.fullstackprojekt.models;

import java.util.List;

public class WishList implements Comparable<WishList>{
    private int id;
    private String name;
    private String description;
    private int userId;
    private int ownerId;
    private List<Wish> wishes;
    private boolean isOwner;


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

    public WishList(int id, String name, String description, int userId, int ownerId, boolean isOwner) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.userId = userId;
        this.ownerId = ownerId;
        this.isOwner = isOwner;
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

    public boolean getIsOwner() {
        return isOwner;
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

    @Override
    public int compareTo(WishList o) {
        return this.name.compareTo(o.name);
    }
}