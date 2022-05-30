package com.springboot.app.entities.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springboot.app.entities.enums.MealType;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MealDTO {

    private Integer userId;
    private Integer mealId;
    private MealType mealType;
    private Date mealTime;
}
