package com.springboot.app.controllers;

import com.springboot.app.entities.FoodItem;
import com.springboot.app.servicies.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping(value = "/foodItems")
    public List<FoodItem> getFoodItems() {
        return foodService.getFoodItems();
    }
}
