package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryReader {

    private String vendingInventory = "vendingmachine.csv";
    private File inventoryFile = new File(vendingInventory);

    private List<String> getInventory(){
        List<String> vendingCsv = new ArrayList<>();
        try (Scanner vendingScanner = new Scanner(inventoryFile)) {
            while (vendingScanner.hasNextLine()) {
                vendingCsv.add(vendingScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
    return vendingCsv;

}
