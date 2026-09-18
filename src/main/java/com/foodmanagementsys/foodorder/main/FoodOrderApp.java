package com.foodmanagementsys.foodorder.main;

import com.foodmanagementsys.foodorder.controller.FoodOrderController;
import com.foodmanagementsys.foodorder.util.InputUtil;

public class FoodOrderApp {

    public static void main(String[] args) {

        FoodOrderController controller =
                new FoodOrderController();

        while (true) {

            System.out.println();
            System.out.println(
                    "================================================");

            System.out.println(
                    "          FOOD ORDER MANAGEMENT SYSTEM");

            System.out.println(
                    "================================================");

            System.out.println("1.  Add Food");
            System.out.println("2.  View Food");
            System.out.println("3.  Search Food");
            System.out.println("4.  Update Food");
            System.out.println("5.  Delete Food");

            System.out.println();

            System.out.println("6.  Add Customer");
            System.out.println("7.  View Customers");
            System.out.println("8.  Update Customer");
            System.out.println("9.  Delete Customer");

            System.out.println();

            System.out.println("10. Place Order");
            System.out.println("11. View Orders");
            System.out.println("12. Update Order Status");
            System.out.println("13. Delete Order");

            System.out.println();

            System.out.println("14. Exit");

            System.out.println(
                    "================================================");

            int choice =
                    InputUtil.getInt(
                            "Enter your choice: ");

            switch (choice) {

                case 1:
                    controller.addFood();
                    break;

                case 2:
                    controller.viewFood();
                    break;

                case 3:
                    controller.searchFood();
                    break;

                case 4:
                    controller.updateFood();
                    break;

                case 5:
                    controller.deleteFood();
                    break;

                case 6:
                    controller.addCustomer();
                    break;

                case 7:
                    controller.viewCustomers();
                    break;

                case 8:
                    controller.updateCustomer();
                    break;

                case 9:
                    controller.deleteCustomer();
                    break;

                case 10:
                    controller.placeOrder();
                    break;

                case 11:
                    controller.viewOrders();
                    break;

                case 12:
                    controller.updateOrderStatus();
                    break;

                case 13:
                    controller.deleteOrder();
                    break;

                case 14:
                    System.out.println(
                            "Thank you for using Food Order Management System!");
                    return;

                default:
                    System.out.println(
                            "Invalid choice!");
            }
        }
    }
}