package com.techelevator.view;

import java.math.BigDecimal;

public class Drink extends Products{
    public Drink(String name, double price) {
        super(name, price);
    }
    @Override
    public String getSound() {
        return "Cheers Glug, Glug!";
    }
}
