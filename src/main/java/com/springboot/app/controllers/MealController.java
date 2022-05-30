package com.springboot.app.controllers;

import com.springboot.app.entities.Meal;
import com.springboot.app.entities.dto.MealDTO;
import com.springboot.app.servicies.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MealController {

    private final MealService mealService;

    @GetMapping(value = "/getMeals")
    private List<Meal> getMeals() {
        return mealService.getMeals();
    }

    @GetMapping(value = "/getMeal")
    private List<Meal> getMealsForUser(@RequestParam(name = "userId") Integer userId) throws Exception {
        return mealService.getMealsPerUserId(userId);
    }

    @PostMapping(value = "/addMeal")
    public void addMeal(@RequestBody MealDTO mealDTO) throws Exception {
        mealService.addMeal(mealDTO);
    }
}
