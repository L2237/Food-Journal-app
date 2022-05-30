package com.springboot.app.servicies;

import com.springboot.app.entities.FoodItem;
import com.springboot.app.repositories.FoodItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodItemRepository foodItemRepository;

    public List<FoodItem> getFoodItems() {
        return foodItemRepository.findAll();
    }

    public FoodItem getFoodItem(final String foodName) throws Exception{
        return foodItemRepository.findByFoodName(foodName).orElseThrow(() -> new Exception("Food name: " + foodName + " does not exist in DB!"));
    }

    public void addFoodItem(final FoodItem foodItem) {
        foodItemRepository.save(foodItem);
    }

    @Transactional
    public void deleteFoodItemByNameOrId(final String foodNameOrFoodId) {
        try {
            Integer foodId = Integer.parseInt(foodNameOrFoodId);
            foodItemRepository.deleteByFoodNameOrFoodId(null, foodId);
        } catch (NumberFormatException numberFormatException) {
            foodItemRepository.deleteByFoodNameOrFoodId(foodNameOrFoodId, null);
        }
    }

}
