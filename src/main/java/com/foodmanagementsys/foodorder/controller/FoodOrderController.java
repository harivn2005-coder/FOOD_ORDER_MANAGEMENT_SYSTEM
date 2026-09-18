package com.foodmanagementsys.foodorder.controller;

import java.util.List;

import com.foodmanagementsys.foodorder.exception.FoodNotFoundException;
import com.foodmanagementsys.foodorder.exception.OrderNotFoundException;
import com.foodmanagementsys.foodorder.model.Customer;
import com.foodmanagementsys.foodorder.model.Food;
import com.foodmanagementsys.foodorder.model.FoodOrder;
import com.foodmanagementsys.foodorder.service.CustomerService;
import com.foodmanagementsys.foodorder.service.CustomerServiceImpl;
import com.foodmanagementsys.foodorder.service.FoodService;
import com.foodmanagementsys.foodorder.service.FoodServiceImpl;
import com.foodmanagementsys.foodorder.service.OrderService;
import com.foodmanagementsys.foodorder.service.OrderServiceImpl;
import com.foodmanagementsys.foodorder.util.InputUtil;

public class FoodOrderController {

    private FoodService foodService =
            new FoodServiceImpl();

    private CustomerService customerService =
            new CustomerServiceImpl();

    private OrderService orderService =
            new OrderServiceImpl();


    // ADD FOOD
    public void addFood() {
    	System.out.println("STEP 1");
        String name =
                InputUtil.getString(
                        "Enter food name: ");
        System.out.println("STEP 2");
        String category =
                InputUtil.getString(
                        "Enter category: ");
        System.out.println("STEP 3");
        double price =
                InputUtil.getDouble(
                        "Enter price: ");
        System.out.println("STEP 4");
        int quantity =
                InputUtil.getInt(
                        "Enter quantity: ");
        System.out.println("STEP 5");
        System.out.println("Food Added Successfully!!!8");
        Food food =
                new Food(
                        name,
                        category,
                        price,
                        quantity
                );

        foodService.addFood(food);
    }


    // VIEW FOOD
    public void viewFood() {

        List<Food> list =
                foodService.getAllFood();

        System.out.println(
                "\n========== FOOD MENU ==========");

        if (list.isEmpty()) {
            System.out.println(
                    "No food available.");
            return;
        }

        for (Food food : list) {
            System.out.println(food);
        }
    }


    // SEARCH FOOD
    public void searchFood() {

        String name =
                InputUtil.getString(
                        "Enter food name: ");

        List<Food> list =
                foodService.searchFood(name);

        if (list.isEmpty()) {
            System.out.println(
                    "Food not found.");
            return;
        }

        for (Food food : list) {
            System.out.println(food);
        }
    }
 // UPDATE FOOD
    public void updateFood() {


        int foodId = InputUtil.getInt(
                "Enter food ID: ");


        Food food = foodService.getFoodById(foodId);


        if (food == null) {
            System.out.println("Food not found!");
            return;
        }


        String name = InputUtil.getString(
                "Enter new food name: ");


        String category = InputUtil.getString(
                "Enter new category: ");


        double price = InputUtil.getDouble(
                "Enter new price: ");


        int quantity = InputUtil.getInt(
                "Enter new quantity: ");


        food.setFoodName(name);
        food.setCategory(category);
        food.setPrice(price);
        food.setQuantity(quantity);


        boolean result =
                foodService.updateFood(food);


        if (result) {
            System.out.println(
                    "Food updated successfully!");
        } else {
            System.out.println(
                    "Food could not be updated.");
        }
    }
 // DELETE FOOD
    public void deleteFood() {


        int foodId = InputUtil.getInt(
                "Enter food ID: ");


        Food food = foodService.getFoodById(foodId);


        if (food == null) {
            System.out.println("Food not found!");
            return;
        }


        boolean result =
                foodService.deleteFood(foodId);


        if (result) {
            System.out.println(
                    "Food deleted successfully!");
        } else {
            System.out.println(
                    "Food could not be deleted.");
        }
    }
    // ADD CUSTOMER
    public void addCustomer() {

        String name =
                InputUtil.getString(
                        "Enter customer name: ");

        String phone =
                InputUtil.getString(
                        "Enter phone: ");

        String address =
                InputUtil.getString(
                        "Enter address: ");

        Customer customer =
                new Customer(
                        name,
                        phone,
                        address
                );

        customerService.addCustomer(customer);
    }


    // VIEW CUSTOMERS
    public void viewCustomers() {

        List<Customer> list =
                customerService.getAllCustomers();

        System.out.println(
                "\n========== CUSTOMERS ==========");

        for (Customer customer : list) {
            System.out.println(customer);
        }
    }

 // UPDATE CUSTOMER
    public void updateCustomer() {


        int customerId = InputUtil.getInt(
                "Enter customer ID: ");


        Customer customer =
                customerService
                        .getCustomerById(customerId);


        if (customer == null) {


            System.out.println(
                    "Customer not found!");


            return;
        }


        String name = InputUtil.getString(
                "Enter new customer name: ");


        String phone = InputUtil.getString(
                "Enter new phone: ");


        String address = InputUtil.getString(
                "Enter new address: ");


        customer.setCustomerName(name);
        customer.setPhone(phone);
        customer.setAddress(address);


        boolean result =
                customerService
                        .updateCustomer(customer);


        if (result) {


            System.out.println(
                    "Customer updated successfully!");


        } else {


            System.out.println(
                    "Customer could not be updated.");
        }
    }
    
 // DELETE CUSTOMER
    public void deleteCustomer() {


        int customerId = InputUtil.getInt(
                "Enter customer ID: ");


        Customer customer =
                customerService
                        .getCustomerById(customerId);


        if (customer == null) {


            System.out.println(
                    "Customer not found!");


            return;
        }


        boolean result =
                customerService
                        .deleteCustomer(customerId);


        if (result) {


            System.out.println(
                    "Customer deleted successfully!");


        } else {


            System.out.println(
                    "Customer could not be deleted.");
        }
    }
    // PLACE ORDER
    public void placeOrder() {

        int customerId =
                InputUtil.getInt(
                        "Enter customer ID: ");

        int foodId =
                InputUtil.getInt(
                        "Enter food ID: ");

        int quantity =
                InputUtil.getInt(
                        "Enter quantity: ");

        Food food =
		        foodService.getFoodById(foodId);

		if (quantity > food.getQuantity()) {

		    System.out.println(
		            "Insufficient food quantity.");

		    return;
		}

		double total =
		        food.getPrice() * quantity;

		FoodOrder order =
		        new FoodOrder(
		                customerId,
		                foodId,
		                quantity,
		                total,
		                "PLACED"
		        );

		orderService.placeOrder(order);

		System.out.println(
		        "Total Bill: ₹" + total);
    }


    // VIEW ORDERS
    public void viewOrders() {

        List<FoodOrder> list =
                orderService.getAllOrders();

        System.out.println(
                "\n========== ORDERS ==========");

        if (list.isEmpty()) {
            System.out.println(
                    "No orders found.");
            return;
        }

        for (FoodOrder order : list) {
            System.out.println(order);
        }
    }


    // UPDATE ORDER STATUS
    public void updateOrderStatus() {

        int id =
                InputUtil.getInt(
                        "Enter order ID: ");

        String status =
                InputUtil.getString(
                        "Enter status: ");

        try {

            orderService.updateOrderStatus(
                    id,
                    status
            );

        } catch (OrderNotFoundException e) {

            System.out.println(
                    e.getMessage());
        }
    }


    // DELETE ORDER
    public void deleteOrder() {

        int id =
                InputUtil.getInt(
                        "Enter order ID: ");

        try {

            orderService.deleteOrder(id);

        } catch (OrderNotFoundException e) {

            System.out.println(
                    e.getMessage());
        }
    }
}