package com.techelevator;

//it manages the inventory of VM-800. methods includes inventory, get a product by slot code, stock products, check availability of product.It uses hash map.

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Product> products;

    public Inventory() {
        products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product.getSlotCode(), product);
    }

    public void removeProduct(String slotCode) {
        products.remove(slotCode);
    }

    public Product getProduct(String slotCode) {
        return products.get(slotCode);
    }

    public boolean containsProduct(String slotCode) {
        return products.containsKey(slotCode);
    }

    public void displayInventory() {
        for (Map.Entry<String, Product> entry : products.entrySet()) {
            String slotCode = entry.getKey();
            Product product = entry.getValue();
            System.out.println(slotCode + " - " + product.getName() + " - $" + product.getPrice());
        }
    }
}