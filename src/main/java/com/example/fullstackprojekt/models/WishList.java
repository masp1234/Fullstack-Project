package com.example.fullstackprojekt.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

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

    public WishList(String name, String description, int userId) {
        this.name= name;
        this.description= description;
        this.userId= userId;
    }

    public WishList(String name, String description) {
        this.name=name;
        this.description=description;
    }

    public int getId() {
        return id;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", userId=" + userId +
                ", ownerId=" + ownerId +
                ", wishes=" + wishes +
                '}';
    }
}