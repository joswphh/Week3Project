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
            if (scanner.hasNextInt()) {
                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        userCart.clearCart();
                        userCart.writeCartToFile();
                        System.out.println("You have checked out thank you.");
                        System.exit(0);
                        break;
                    case 2:
                        userCart.writeCartToFile();
                        RemoveItem(userCart);
                        break;
                    case 3:
                        System.out.println("You are heading back to the main menu.");
                        validInput = true; // Exit the loop and return to the main menu
                        break;
                    default:
                        System.out.println("Invalid input. Please try again.");
                }
            }
            else{
                System.out.println("Invalid input was enter please try again.");
            }
        }

        }
        public static void addToCartFromCartFile (Cart userCart){
            try {
                BufferedReader cartReader = new BufferedReader(new FileReader("src/main/resources/addedProducts.txt"));

                String line;
                while ((line = cartReader.readLine()) != null) {
                    System.out.println(line + "\n"); // Output each line from "addedProducts.txt"
                    // Parse and process the data if needed
                }

                cartReader.close();
            } catch (IOException ex) {
                System.out.println("Couldn't read from cart.txt.");
            }
        }

        public static void RemoveItem (Cart userCart){
            Scanner scanner = new Scanner(System.in);
            System.out.println("What would you like to Remove?");
            System.out.println("Please enter SKU of the item.");
            String removeSku = scanner.nextLine();
            userCart.removeProductBySku(removeSku);
            System.out.println("Item successfully removed.");

        }

    }

