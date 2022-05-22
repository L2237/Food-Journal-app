package com.springboot.app.controllers;

import com.springboot.app.entities.FoodItem;
import com.springboot.app.servicies.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping(value = "/foodItems")
    public List<FoodItem> getFoodItems() {
        return foodService.getFoodItems();
    }

    @PostMapping(value = "/addFoodItem")
    public void createFoodItem(@RequestBody FoodItem foodItem) {
        foodService.addFoodItem(foodItem);
    }

    @DeleteMapping(value = "/deleteFoodItemByName/{foodName}")
    public void deleteFoodItemByName(@PathVariable(value = "foodName") String foodName) {
        foodService.deleteFoodItemByName(foodName);
    }

    @DeleteMapping(value = "/deleteFoodItem/{foodId}")
    public void deleteFoodItemById(@PathVariable(value = "foodId") Integer foodId) {
        foodService.deleteFoodItem(foodId);
    }
}
