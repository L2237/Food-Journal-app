package com.springboot.app.entities.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CaloriesPerServingDTO {

    private Double caloriesPerServing;
    private String unit;
}
