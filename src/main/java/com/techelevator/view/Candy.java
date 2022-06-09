package com.techelevator.view;

import java.math.BigDecimal;

public class Candy extends Products {
    public Candy(String name, double price) {
        super(name, price);
    }

    @Override
    public String getSound() {
        return "Munch Munch, Mmm-Good!";
    }
}
