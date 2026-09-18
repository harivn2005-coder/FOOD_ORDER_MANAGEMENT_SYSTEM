package com.foodmanagementsys.foodorder.repository;


import java.util.List;


import com.foodmanagementsys.foodorder.model.Food;


public interface FoodRepository {


    boolean addFood(Food food);


    List<Food> getAllFood();


    Food getFoodById(int foodId);


    boolean updateFood(Food food);


    boolean deleteFood(int foodId);


    List<Food> searchFood(String name);
}