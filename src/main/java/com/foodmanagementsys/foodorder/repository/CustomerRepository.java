package com.foodmanagementsys.foodorder.repository;


import java.util.List;


import com.foodmanagementsys.foodorder.model.Customer;


public interface CustomerRepository {


    boolean addCustomer(Customer customer);


    List<Customer> getAllCustomers();


    Customer getCustomerById(int customerId);


    boolean updateCustomer(Customer customer);


    boolean deleteCustomer(int customerId);
}