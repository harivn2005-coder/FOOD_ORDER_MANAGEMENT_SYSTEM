package com.foodmanagementsys.foodorder.service;


import java.util.List;


import com.foodmanagementsys.foodorder.model.Customer;
import com.foodmanagementsys.foodorder.repository.CustomerRepository;
import com.foodmanagementsys.foodorder.repository.CustomerRepositoryImpl;


public class CustomerServiceImpl
        implements CustomerService {


    private CustomerRepository customerRepository =
            new CustomerRepositoryImpl();


    @Override
    public boolean addCustomer(Customer customer) {


        return customerRepository.addCustomer(customer);
    }


    @Override
    public List<Customer> getAllCustomers() {


        return customerRepository.getAllCustomers();
    }


    @Override
    public Customer getCustomerById(int customerId) {


        return customerRepository
                .getCustomerById(customerId);
    }


    @Override
    public boolean updateCustomer(Customer customer) {


        return customerRepository
                .updateCustomer(customer);
    }


    @Override
    public boolean deleteCustomer(int customerId) {


        return customerRepository
                .deleteCustomer(customerId);
    }
}