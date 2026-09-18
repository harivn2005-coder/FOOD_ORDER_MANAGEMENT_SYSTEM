package com.foodmanagementsys.foodorder.model;

public class Food {

    private int foodId;
    private String foodName;
    private String category;
    private double price;
    private int quantity;

    public Food() {
    }

    public Food(int foodId, String foodName, String category,
                double price, int quantity) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public Food(String foodName, String category,
                double price, int quantity) {
        this.foodName = foodName;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Food ID: " + foodId
                + ", Name: " + foodName
                + ", Category: " + category
                + ", Price: ₹" + price
                + ", Available: " + quantity;
    }
}