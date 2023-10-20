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
                        SearchByDepartment(inventoryItems);
                        break;
                    case 2:
                        //AddProducts(inventoryItems);
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

    public static void SearchByDepartment(ArrayList<StoreConstructor> products) {
        boolean valid = false;
        while (!valid) {
            System.out.println("How would you like to view the products?");
            System.out.println("Press 1 to search by department");
            System.out.println("Press 2 to search by product name");
            System.out.println("Press 3 to search by product price");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter what you would like to choose");
            int user = scanner.nextInt();
            scanner.nextLine();


                switch (user) {
                    case 1:
                        System.out.println("Enter the department you would like to search by");
                        String userInput1 = scanner.nextLine();
                        for (StoreConstructor onlineStore : products) {
                            if (onlineStore.getDepartment().equalsIgnoreCase(userInput1)) {
                                System.out.printf("SKU: %s, ProductName: %s, Price: %.2f, Department: %s%n",
                                        onlineStore.getSku(), onlineStore.getProductName(), onlineStore.getPrice(), onlineStore.getDepartment());
                            }
                        }
                        break;

                    case 2:
                        System.out.println("What is the name of your product?");
                        String userInput2 = scanner.nextLine();
                        for (StoreConstructor onlineStore2 : products) {
                            if (onlineStore2.getProductName().equalsIgnoreCase(userInput2)) {
                                System.out.printf("SKU: %s, ProductName: %s, Price: %.2f, Department: %s%n",
                                        onlineStore2.getSku(), onlineStore2.getProductName(), onlineStore2.getPrice(), onlineStore2.getDepartment());
                            }
                        }
                        break;

                    case 3:
                        System.out.println("What is your desired price?");
                        double userInput3 = scanner.nextDouble();
                        for (StoreConstructor onlineStore3 : products) {
                            if (onlineStore3.getPrice() == userInput3) {
                                System.out.printf("SKU: %s, ProductName: %s, Price: %.2f, Department: %s%n",
                                        onlineStore3.getSku(), onlineStore3.getProductName(), onlineStore3.getPrice(), onlineStore3.getDepartment());
                            }
                        }
                        break;

                    default:
                        System.out.println("Invalid input");
                        break;
                }
            }
        }
    }