package com.techelevator.view;


public abstract class Product {
    private String name;
    private double price;
    private int quantity = 5;

    public Product(String name, double price) {
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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}

