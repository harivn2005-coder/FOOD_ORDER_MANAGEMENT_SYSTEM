package com.foodmanagementsys.foodorder.service;


import java.util.List;


import com.foodmanagementsys.foodorder.model.Food;
import com.foodmanagementsys.foodorder.repository.FoodRepository;
import com.foodmanagementsys.foodorder.repository.FoodRepositoryImpl;


public class FoodServiceImpl implements FoodService {


    private FoodRepository foodRepository =
            new FoodRepositoryImpl();


    @Override
    public boolean addFood(Food food) {
        return foodRepository.addFood(food);
    }


    @Override
    public List<Food> getAllFood() {
        return foodRepository.getAllFood();
    }


    @Override
    public Food getFoodById(int foodId) {
        return foodRepository.getFoodById(foodId);
    }


    @Override
    public boolean updateFood(Food food) {
        return foodRepository.updateFood(food);
    }


    @Override
    public boolean deleteFood(int foodId) {
        return foodRepository.deleteFood(foodId);
    }


    @Override
    public List<Food> searchFood(String name) {
        return foodRepository.searchFood(name);
    }
}