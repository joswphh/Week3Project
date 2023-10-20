package org.example;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DisplayCart {
    public static void displayCart() {
        try {
            FileInputStream displayProducts = new FileInputStream("src/main/resources/products.csv");
            Scanner productScanner = new Scanner(displayProducts);

            ArrayList<StoreConstructor> inventoryItems = new ArrayList<>();
            productScanner.nextLine();

            while (productScanner.hasNextLine()) {
                String line = productScanner.nextLine();
                String[] productInventory = line.split("\\|");
                String productSku = productInventory[0];
                String productName = productInventory[1];
                double price = Double.parseDouble(productInventory[2]);
                String productDepartment = productInventory[3];

                StoreConstructor newItem = new StoreConstructor(productSku, productName, price, productDepartment);

                inventoryItems.add(newItem);


            }

            for (StoreConstructor item : inventoryItems) {
                System.out.printf("SKU: %s Product Name: %s Price: %.2f Department: %s %n", item.getSku(), item.getProductName(),
                        item.getPrice(), item.getDepartment());
            }

            Scanner scanner = new Scanner(System.in);
            boolean valid = false;
            while (!valid) {
                System.out.println("What would you like to do?");
                System.out.println("1) Search for products by department.");
                System.out.println("2) Add products to the cart.");
                System.out.println("3) Back to main menu.");
                int userInput = scanner.nextInt();

                switch (userInput) {
                    case 1:
                        //SearchByDepartment(inventoryItems);
                        break;
                    case 2:
                       // AddProducts(inventoryItems);
                        break;
                    case 3:
                        System.out.println("Going back to main menu.");
                        valid = true;
                        break;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Sorry that file was not found.");
        }

    }
}