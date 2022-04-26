package com.example.fullstackprojekt.models;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


public class Wish {
    private int id;
    private String name;
    private String description;
    private double price;
    private String link;
    private int wishlistId;
    private boolean isReserved = false;

    public Wish(int id, String name, String description, double price, String link) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.link = link;
    }

    public Wish(String name, String description, double price, String link, int wishlistId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.link = link;
        this.wishlistId = wishlistId;
    }

    public Wish(String name, String description, double price, String link) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.link = link;

    }

    public Wish(int id, String name, String description, double price, String link, boolean isReserved) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.link = link;
        this.isReserved=isReserved;
    }
    public Wish(int id, String name, String description, double price, String link, int wishlistId, boolean isReserved) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.link = link;
        this.wishlistId = wishlistId;
        this.isReserved = isReserved;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getLink() {
        return link;
    }

    public int getWishlistId() {
        return wishlistId;
    }

    public boolean isReserved() {
        return isReserved;
    }

    @Override
    public String toString() {
        return "Wish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", link='" + link + '\'' +
                ", wishlistId=" + wishlistId +
                ", isReserved=" + isReserved +
                '}';
    }
}
