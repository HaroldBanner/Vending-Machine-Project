package com.techelevator.view;

import java.math.BigDecimal;

public class Gum extends Products{
    public Gum(String name, double price) {
        super(name, price);
    }
    @Override
    public String getSound() {
        return "Chew Chew, Pop!";
    }
}
