package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Inventory {

    private Map<String, Product> inventory = new HashMap<>();

    public Inventory() {
    }

    public Map<String, Product> getInventory() {
        return inventory;
    }

    public void printInventory() {
        for (Map.Entry<String, Product> entry : inventory.entrySet()) {
            String code = entry.getKey();
            Product product = entry.getValue();
            String quantity = product.getQuantity() == 0 ? "SOLD OUT" : String.valueOf(product.getQuantity());
            System.out.println(code + " " + product.getName() + " $" + String.format("%.2f", product.getPrice()) + " (" + quantity + ")");
        }

    }

    public void readInventory() {
        String vendingInventory = "vendingmachine.csv";
        File inventoryFile = new File(vendingInventory);
        try (Scanner vendingScanner = new Scanner(inventoryFile)) {
            while (vendingScanner.hasNextLine()) {
                String[] itemSplit = vendingScanner.nextLine().split(("\\|"));
                String code = itemSplit[0];
                String name = itemSplit[1];
                double price = Double.parseDouble(itemSplit[2]);
                String type = itemSplit[3];
                Product product = null;
                if (type.equals("Candy")) {
                    product = new Candy(name, price);
                } else if (type.equals("Chip")) {
                    product = new Chip(name, price);
                } else if (type.equals("Drink")) {
                    product = new Drink(name, price);
                } else if (type.equals("Gum")) {
                    product = new Gum(name, price);
                }
                inventory.put(code, product);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectProduct(String productCode, Money money, TransactionLogger log) {
        Product product = inventory.get(productCode);
        if (product.getPrice() > money.getBalance()) {
            System.out.println("Insufficient Funds");
        } else if (product.getQuantity() == 0) {
            System.out.println("SOLD OUT");
        } else {
            money.subtractBalance(product.getPrice());
            product.setQuantity(product.getQuantity() - 1);
            System.out.println(product.getName() + " $" + String.format("%.2f", product.getPrice()) + " $" + String.format("%.2f", money.getBalance()));
            System.out.println(product.getSound());
            log.log(product.getName(), product.getPrice(), money.getBalance());
        }
    }
}