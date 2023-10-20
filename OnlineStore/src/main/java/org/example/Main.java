package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Welcome to Better Buy!");
            System.out.println("1) List Products");
            System.out.println("2) Add Products and Remove");
            System.out.println("3) Search For Product");
            System.out.println("4) Display Cart");
            System.out.println("5) Exit Better Buy");
            Scanner scanner = new Scanner(System.in);
            int userInput = scanner.nextInt();

            switch(userInput){

            }
        }

    }
}