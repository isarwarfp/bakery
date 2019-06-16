package com.hexad.interview.model;

public class Pack {
    private final double price;
    private final int quantity;

    public Pack(double price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
}
