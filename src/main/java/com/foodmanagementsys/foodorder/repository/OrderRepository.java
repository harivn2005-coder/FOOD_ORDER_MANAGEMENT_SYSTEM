package com.foodmanagementsys.foodorder.repository;

import java.util.List;

import com.foodmanagementsys.foodorder.model.FoodOrder;

public interface OrderRepository {

    boolean placeOrder(FoodOrder order);

    List<FoodOrder> getAllOrders();

    FoodOrder getOrderById(int orderId);

    boolean updateOrderStatus(
            int orderId,
            String status);

    boolean deleteOrder(int orderId);
}
