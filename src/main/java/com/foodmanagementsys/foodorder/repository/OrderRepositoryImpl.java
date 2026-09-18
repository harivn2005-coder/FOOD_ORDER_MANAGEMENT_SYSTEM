package com.foodmanagementsys.foodorder.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodmanagementsys.foodorder.database.DBConnection;
import com.foodmanagementsys.foodorder.model.FoodOrder;

public class OrderRepositoryImpl
        implements OrderRepository {

    @Override
    public boolean placeOrder(
            FoodOrder order) {

        String sql =
                "INSERT INTO food_order " +
                "(customer_id, food_id, quantity, " +
                "total_amount, status) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection con =
                     DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setInt(1,
                    order.getCustomerId());

            ps.setInt(2,
                    order.getFoodId());

            ps.setInt(3,
                    order.getQuantity());

            ps.setDouble(4,
                    order.getTotalAmount());

            ps.setString(5,
                    order.getStatus());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Database Error: "
                    + e.getMessage());

            return false;
        }
    }

    @Override
    public List<FoodOrder> getAllOrders() {

        List<FoodOrder> list =
                new ArrayList<>();

        String sql =
                "SELECT * FROM food_order";

        try (Connection con =
                     DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(sql);
             ResultSet rs =
                     ps.executeQuery()) {

            while (rs.next()) {

                FoodOrder order =
                        new FoodOrder();

                order.setOrderId(
                        rs.getInt("order_id"));

                order.setCustomerId(
                        rs.getInt("customer_id"));

                order.setFoodId(
                        rs.getInt("food_id"));

                order.setQuantity(
                        rs.getInt("quantity"));

                order.setTotalAmount(
                        rs.getDouble("total_amount"));

                order.setStatus(
                        rs.getString("status"));

                list.add(order);
            }

        } catch (SQLException e) {

            System.out.println(
                    "Database Error: "
                    + e.getMessage());
        }

        return list;
    }

    @Override
    public FoodOrder getOrderById(
            int orderId) {

        String sql =
                "SELECT * FROM food_order " +
                "WHERE order_id=?";

        try (Connection con =
                     DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setInt(1, orderId);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                return new FoodOrder(
                        rs.getInt("order_id"),
                        rs.getInt("customer_id"),
                        rs.getInt("food_id"),
                        rs.getInt("quantity"),
                        rs.getDouble("total_amount"),
                        rs.getString("status")
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Database Error: "
                    + e.getMessage());
        }

        return null;
    }

    @Override
    public boolean updateOrderStatus(
            int orderId,
            String status) {

        String sql =
                "UPDATE food_order " +
                "SET status=? " +
                "WHERE order_id=?";

        try (Connection con =
                     DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setString(1, status);
            ps.setInt(2, orderId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Database Error: "
                    + e.getMessage());

            return false;
        }
    }

    @Override
    public boolean deleteOrder(
            int orderId) {

        String sql =
                "DELETE FROM food_order " +
                "WHERE order_id=?";

        try (Connection con =
                     DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setInt(1, orderId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Database Error: "
                    + e.getMessage());

            return false;
        }
    }
}