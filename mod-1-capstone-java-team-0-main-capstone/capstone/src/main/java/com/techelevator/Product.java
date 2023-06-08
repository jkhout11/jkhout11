package com.techelevator;

//This class represents Vendo-matic 800. It has properties such as name, price, and type. It includes getters and setters for these properties.

public class Product {
    private String slotCode;
    private String name;
    private double price;
    private String type;

    public Product(String slotCode, String name, double price, String type) {
        this.slotCode = slotCode;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getSlotCode() {
        return slotCode;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }
}
