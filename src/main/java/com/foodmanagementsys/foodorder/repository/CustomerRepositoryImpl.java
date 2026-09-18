package com.foodmanagementsys.foodorder.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodmanagementsys.foodorder.database.DBConnection;
import com.foodmanagementsys.foodorder.model.Customer;

public class CustomerRepositoryImpl
        implements CustomerRepository {

    @Override
    public boolean addCustomer(Customer customer) {

        String sql =
                "INSERT INTO customer " +
                "(customer_name, phone, address) " +
                "VALUES (?, ?, ?)";

        try (Connection con =
                     DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setString(1,
                    customer.getCustomerName());

            ps.setString(2,
                    customer.getPhone());

            ps.setString(3,
                    customer.getAddress());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Database Error: "
                    + e.getMessage());

            return false;
        }
    }

    @Override
    public List<Customer> getAllCustomers() {

        List<Customer> list =
                new ArrayList<>();

        String sql =
                "SELECT * FROM customer";

        try (Connection con =
                     DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(sql);
             ResultSet rs =
                     ps.executeQuery()) {

            while (rs.next()) {

                Customer customer =
                        new Customer();

                customer.setCustomerId(
                        rs.getInt("customer_id"));

                customer.setCustomerName(
                        rs.getString("customer_name"));

                customer.setPhone(
                        rs.getString("phone"));

                customer.setAddress(
                        rs.getString("address"));

                list.add(customer);
            }

        } catch (SQLException e) {

            System.out.println(
                    "Database Error: "
                    + e.getMessage());
        }

        return list;
    }

    @Override
    public Customer getCustomerById(int customerId) {


        String sql =
                "SELECT * FROM customer WHERE customer_id = ?";


        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(sql)) {


            ps.setInt(1, customerId);


            ResultSet rs = ps.executeQuery();


            if (rs.next()) {


                return new Customer(
                        rs.getInt("customer_id"),
                        rs.getString("customer_name"),
                        rs.getString("phone"),
                        rs.getString("address")
                );
            }


        } catch (SQLException e) {


            System.out.println(
                    "Database Error: " + e.getMessage());
        }


        return null;
    }

    @Override
    public boolean updateCustomer(Customer customer) {


        String sql =
                "UPDATE customer SET " +
                "customer_name = ?, " +
                "phone = ?, " +
                "address = ? " +
                "WHERE customer_id = ?";


        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(sql)) {


            ps.setString(1, customer.getCustomerName());
            ps.setString(2, customer.getPhone());
            ps.setString(3, customer.getAddress());
            ps.setInt(4, customer.getCustomerId());


            return ps.executeUpdate() > 0;


        } catch (SQLException e) {


            System.out.println(
                    "Database Error: " + e.getMessage());


            return false;
        }
    }

    @Override
    public boolean deleteCustomer(int customerId) {


        String sql =
                "DELETE FROM customer WHERE customer_id = ?";


        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(sql)) {


            ps.setInt(1, customerId);


            return ps.executeUpdate() > 0;


        } catch (SQLException e) {


            System.out.println(
                    "Database Error: " + e.getMessage());


            return false;
        }
    }
}