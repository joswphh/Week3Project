package org.example;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class CheckoutRemove {
    public static void displayCart() {
        // Initialize the userCart
        Cart userCart = new Cart();

        // Read and add the contents of the "cart.txt" file to the userCart
        addToCartFromCartFile(userCart);

        boolean validInput = false;
        while (!validInput) {
            System.out.println("What would you like to do?");
            System.out.println("1) Check out.");
            System.out.println("2) Remove Product.");
            System.out.println("3) Exit to main menu.");

            Scanner scanner = new Scanner(System.in);
            int userInput = scanner.nextInt();

            switch (userInput) {
                case 1:
                    checkout(userCart);
                    break;
                case 2:
                    // Implement logic to remove a product from the cart
                    // For example, you can ask for the SKU and remove the corresponding product
                    break;
                case 3:
                    System.out.println("You are heading back to the main menu.");
                    validInput = true; // Exit the loop and return to the main menu
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }
    public static void addToCartFromCartFile(Cart userCart) {
        try {
            BufferedReader cartReader = new BufferedReader(new FileReader("src/main/resources/addedProducts.txt"));

            String line;
            while ((line = cartReader.readLine()) != null) {
                System.out.println(line); // Output each line from "addedProducts.txt"
                // Parse and process the data if needed
            }

            cartReader.close();
        } catch (IOException ex) {
            System.out.println("Couldn't read from cart.txt.");
        }
    }
  /*  public static void checkout(Cart userCart) {
        System.out.println("This ");
       for(Cart checkout : userCart){

       }
    }*/
}

