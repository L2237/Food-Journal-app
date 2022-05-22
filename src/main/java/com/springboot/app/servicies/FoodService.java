package com.springboot.app.servicies;

import com.springboot.app.entities.FoodItem;
import com.springboot.app.repositories.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private final FoodItemRepository foodItemRepository;

    public FoodService(FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    public List<FoodItem> getFoodItems() {
        return foodItemRepository.findAll();
    }

    public void addFoodItem(final FoodItem foodItem) {
        foodItemRepository.save(foodItem);
    }

    @Transactional
    public void deleteFoodItemByName(final String foodName) {
        foodItemRepository.deleteByFoodName(foodName);
    }

    @Transactional
    public void deleteFoodItem(final Integer foodId) {
        foodItemRepository.deleteById(foodId);
    }
}
