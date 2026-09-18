package com.foodmanagementsys.foodorder.service;

import java.util.List;

import com.foodmanagementsys.foodorder.exception.OrderNotFoundException;
import com.foodmanagementsys.foodorder.model.FoodOrder;

public interface OrderService {

    void placeOrder(FoodOrder order);

    List<FoodOrder> getAllOrders();

    FoodOrder getOrderById(int id)
            throws OrderNotFoundException;

    void updateOrderStatus(
            int id,
            String status)
            throws OrderNotFoundException;

    void deleteOrder(int id)
            throws OrderNotFoundException;
}