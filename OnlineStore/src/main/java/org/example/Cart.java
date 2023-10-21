package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.util.ArrayList;

public class Cart {
    private ArrayList<StoreConstructor> cartItems;
    private String cartFilePath = "src/main/resources/addedProducts.txt";
    public Cart() {
        cartItems = new ArrayList<>();
    }

    // Add a product to the cart
    public void addToCart(StoreConstructor product) {
        cartItems.add(product);
    }

    // Remove a product from the cart by SKU
    public void  removeProductBySku(String sku) {
        cartItems.removeIf(product -> product.getSku().equals(sku));
    }

    // Clear the cart
    public void clearCart() {
        cartItems.clear();
    }
    public void writeCartToFile() {
        try (FileWriter cartWriter = new FileWriter(cartFilePath)) {
            for (StoreConstructor product : cartItems) {
                cartWriter.write(product.getSku() + " | " + product.getProductName() +
                        " | " + product.getPrice() + " | " + product.getDepartment() + "\n");
            }
        } catch (IOException ex) {
            System.out.println("Couldn't write to cart file.");
        }
    }

    // Get the items in the cart
    public ArrayList<StoreConstructor> getCartItems() {
        return cartItems;
    }
}
