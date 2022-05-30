package com.springboot.app.controllers;

import com.springboot.app.entities.FoodItem;
import com.springboot.app.servicies.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    @GetMapping(value = "/foodItems")
    public List<FoodItem> getFoodItems() {
        return foodService.getFoodItems();
    }

    @GetMapping(value = "/foodDetails/{foodName}")
    public FoodItem getFoodDetails(@PathVariable(value = "foodName") String foodName) throws Exception {
        return foodService.getFoodItem(foodName);
    }

    @PostMapping(value = "/addFoodItem")
    public void createFoodItem(@RequestBody FoodItem foodItem) {
        foodService.addFoodItem(foodItem);
    }

    @DeleteMapping(value = "/deleteFoodItem/{foodNameOrId}")
    public void deleteFoodItemByName(@PathVariable(value = "foodNameOrId") String foodNameOrId) {
        foodService.deleteFoodItemByNameOrId(foodNameOrId);
    }
}
