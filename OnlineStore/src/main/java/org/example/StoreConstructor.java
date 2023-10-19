package org.example;

public class StoreConstructor {
    private String sku;
    private String productName;
    private double price;
    private String description;

    public StoreConstructor(String sku, String productName, double price, String description) {
        this.sku = sku;
        this.productName = productName;
        this.price = price;
        this.description = description;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
