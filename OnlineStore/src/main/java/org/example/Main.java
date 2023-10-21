package org.example;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        boolean validInput = false;
        while (true) {
            System.out.println("Welcome to Better Buy!");
            System.out.println("What would you like to do?");
            System.out.println("1) Display products.");
            System.out.println("2) Display Cart.");
            System.out.println("3) Exit the Better Buy online store.");
            Scanner scanner = new Scanner(System.in);
            try {
                int userInput = scanner.nextInt();

                switch (userInput) {
                    case 1:
                        DisplayCart.displayCart();
                        break;
                    case 2:
                        CheckoutRemove.displayCart();
                        break;
                    case 3:
                        System.out.println("Thank you see you later");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid input. Please try again.");
                }
            }
            catch(Exception ex){
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
}


