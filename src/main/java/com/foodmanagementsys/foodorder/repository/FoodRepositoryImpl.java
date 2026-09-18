package com.foodmanagementsys.foodorder.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodmanagementsys.foodorder.database.DBConnection;
import com.foodmanagementsys.foodorder.model.Food;

public class FoodRepositoryImpl
        implements FoodRepository {

    @Override
    public boolean addFood(Food food) {

        String sql =
                "INSERT INTO food " +
                "(food_name, category, price, quantity) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection con =
                     DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setString(1, food.getFoodName());
            ps.setString(2, food.getCategory());
            ps.setDouble(3, food.getPrice());
            ps.setInt(4, food.getQuantity());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Database Error: " +
                    e.getMessage());

            return false;
        }
    }

    @Override
    public List<Food> getAllFood() {

        List<Food> list = new ArrayList<>();

        String sql = "SELECT * FROM food";

        try (Connection con =
                     DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(sql);
             ResultSet rs =
                     ps.executeQuery()) {

            while (rs.next()) {

                Food food = new Food();

                food.setFoodId(
                        rs.getInt("food_id"));

                food.setFoodName(
                        rs.getString("food_name"));

                food.setCategory(
                        rs.getString("category"));

                food.setPrice(
                        rs.getDouble("price"));

                food.setQuantity(
                        rs.getInt("quantity"));

                list.add(food);
            }

        } catch (SQLException e) {

            System.out.println(
                    "Database Error: " +
                    e.getMessage());
        }

        return list;
    }

    @Override
    public Food getFoodById(int foodId) {

        String sql =
                "SELECT * FROM food WHERE food_id=?";

        try (Connection con =
                     DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setInt(1, foodId);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                return new Food(
                        rs.getInt("food_id"),
                        rs.getString("food_name"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Database Error: " +
                    e.getMessage());
        }

        return null;
    }

    @Override
    public boolean updateFood(Food food) {

        String sql =
                "UPDATE food SET " +
                "food_name=?, category=?, " +
                "price=?, quantity=? " +
                "WHERE food_id=?";

        try (Connection con =
                     DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setString(1, food.getFoodName());
            ps.setString(2, food.getCategory());
            ps.setDouble(3, food.getPrice());
            ps.setInt(4, food.getQuantity());
            ps.setInt(5, food.getFoodId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Database Error: " +
                    e.getMessage());

            return false;
        }
    }

    @Override
    public boolean deleteFood(int foodId) {

        String sql =
                "DELETE FROM food WHERE food_id=?";

        try (Connection con =
                     DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setInt(1, foodId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Database Error: " +
                    e.getMessage());

            return false;
        }
    }

    @Override
    public List<Food> searchFood(String name) {

        List<Food> list = new ArrayList<>();

        String sql =
                "SELECT * FROM food " +
                "WHERE food_name LIKE ?";

        try (Connection con =
                     DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setString(1, "%" + name + "%");

            ResultSet rs =
                    ps.executeQuery();

            while (rs.next()) {

                Food food = new Food(
                        rs.getInt("food_id"),
                        rs.getString("food_name"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                );

                list.add(food);
            }

        } catch (SQLException e) {

            System.out.println(
                    "Database Error: " +
                    e.getMessage());
        }

        return list;
    }
}