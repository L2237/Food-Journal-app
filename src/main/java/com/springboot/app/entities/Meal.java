package com.springboot.app.entities;

import com.springboot.app.entities.FoodItem;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Meal {
    private Integer totalCalories;
    private List<FoodItem> ingredients;
}
