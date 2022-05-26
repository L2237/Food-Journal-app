package com.springboot.app.entities.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springboot.app.entities.enums.MealType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MealDTO {

    private Integer userId;
    private MealType mealType;
    private Date mealTime;
}
