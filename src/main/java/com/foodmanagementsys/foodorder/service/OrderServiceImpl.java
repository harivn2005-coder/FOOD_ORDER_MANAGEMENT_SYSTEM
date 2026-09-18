package com.foodmanagementsys.foodorder.service;

import java.util.List;

import com.foodmanagementsys.foodorder.exception.OrderNotFoundException;
import com.foodmanagementsys.foodorder.model.FoodOrder;
import com.foodmanagementsys.foodorder.repository.OrderRepository;
import com.foodmanagementsys.foodorder.repository.OrderRepositoryImpl;

public class OrderServiceImpl
        implements OrderService {

    private OrderRepository repository =
            new OrderRepositoryImpl();

    @Override
    public void placeOrder(FoodOrder order) {

        if (order.getQuantity() <= 0) {
            System.out.println(
                    "Quantity must be greater than 0.");
            return;
        }

        if (repository.placeOrder(order)) {
            System.out.println(
                    "Order placed successfully!");
        } else {
            System.out.println(
                    "Order failed.");
        }
    }

    @Override
    public List<FoodOrder> getAllOrders() {
        return repository.getAllOrders();
    }

    @Override
    public FoodOrder getOrderById(int id)
            throws OrderNotFoundException {

        FoodOrder order =
                repository.getOrderById(id);

        if (order == null) {
            throw new OrderNotFoundException(
                    "Order ID " + id +
                    " not found.");
        }

        return order;
    }

    @Override
    public void updateOrderStatus(
            int id,
            String status)
            throws OrderNotFoundException {

        getOrderById(id);

        if (repository.updateOrderStatus(
                id, status)) {

            System.out.println(
                    "Order status updated!");
        }
    }

    @Override
    public void deleteOrder(int id)
            throws OrderNotFoundException {

        getOrderById(id);

        if (repository.deleteOrder(id)) {
            System.out.println(
                    "Order deleted successfully!");
        }
    }
}