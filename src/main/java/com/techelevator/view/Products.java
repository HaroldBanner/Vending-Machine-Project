package com.techelevator.view;


public abstract class Products {
    private String name;
    private double price;

    public Products(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract String getSound();

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

