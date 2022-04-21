package com.example.fullstackprojekt.models;

import java.util.ArrayList;
import java.util.List;

public class WishStub {


    public static List<Wish> getAllWishesByWishList() {
        List<Wish> wishes = new ArrayList<>();
        wishes.add(new Wish(1, "Sko", "Et par sko i størrelse 45", 300, "google.com"));
        wishes.add(new Wish(2, "Dukke", "en dukke i forskellige farver", 300, "google.com"));
        wishes.add(new Wish(3, "Iphone", "Den nyeste iphone", 300, "apple.com"));
        wishes.add(new Wish(4, "Ønskebusk", "??????????????????????", 300, "ønskebusken.com"));


        return wishes;
    }
}
