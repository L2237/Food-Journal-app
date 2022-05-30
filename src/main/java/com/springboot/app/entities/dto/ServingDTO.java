package com.springboot.app.entities.dto;

import com.springboot.app.entities.FoodItem;
import lombok.Data;

@Data
public class ServingDTO {

    private FoodItem foodItem;
    private Double quantity;
    private MealDTO meal;
}
