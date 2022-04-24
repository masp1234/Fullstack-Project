package com.example.fullstackprojekt.models;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Wish {
    private int id;
    private String name;
    private String description;
    private double price;
    private String link;
    private boolean isReserved = false;

    public Wish(String name, String description, double price, String link, boolean isReserved) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.link = link;
        this.isReserved = isReserved;
    }

    public Wish(int id, String name, String description, double price, String link, boolean isReserved) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.link = link;
        this.isReserved=isReserved;
    }
}
