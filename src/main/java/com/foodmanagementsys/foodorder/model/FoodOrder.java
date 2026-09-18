package com.foodmanagementsys.foodorder.model;

public class FoodOrder {

    private int orderId;
    private int customerId;
    private int foodId;
    private int quantity;
    private double totalAmount;
    private String status;

    public FoodOrder() {
    }

    public FoodOrder(int orderId, int customerId,
                     int foodId, int quantity,
                     double totalAmount, String status) {

        this.orderId = orderId;
        this.customerId = customerId;
        this.foodId = foodId;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public FoodOrder(int customerId, int foodId,
                     int quantity, double totalAmount,
                     String status) {

        this.customerId = customerId;
        this.foodId = foodId;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId
                + ", Customer ID: " + customerId
                + ", Food ID: " + foodId
                + ", Quantity: " + quantity
                + ", Total: ₹" + totalAmount
                + ", Status: " + status;
    }
}