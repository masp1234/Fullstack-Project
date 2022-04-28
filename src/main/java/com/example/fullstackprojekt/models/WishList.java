package com.example.fullstackprojekt.models;


public class WishList implements Comparable<WishList>{
    private int id;
    private String name;
    private String description;
    private int ownerId;
    private boolean isOwner;

    public WishList(int id, String name, String description, int ownerId, boolean isOwner) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ownerId = ownerId;
        this.isOwner = isOwner;
    }

    public WishList(String name, String description, int ownerId) {
        this.name= name;
        this.description= description;
        this.ownerId = ownerId;
    }

    public WishList(int id, String name, String description) {
        this.id = id;
        this.name= name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public boolean isOwner() {
        return isOwner;
    }
    @Override
    public String toString() {
        return "WishList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ownerId=" + ownerId +
                '}';
    }

    @Override
    public int compareTo(WishList o) {
        return this.name.compareTo(o.name);
    }
}