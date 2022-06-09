package com.techelevator.view;

import java.math.BigDecimal;

public class Chip extends Products {

    public Chip(String name, double price) {
        super(name, price);
    }

    @Override
    public String getSound() {
        return "Crunch Crunch, Crunch!";
    }
}
