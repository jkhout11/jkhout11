package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventoryReader {

    public static Map<String, Product> createInventory(String filePath) {
        Map<String, Product> inventory = new HashMap<>();

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");

                if (parts.length == 4) {
                    String slotCode = parts[0];
                    String name = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    String type = parts[3];

                    Product product = new Product(slotCode, name, price, type);
                    inventory.put(slotCode, product);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found: " + filePath);
        }

        return inventory;
    }
}
