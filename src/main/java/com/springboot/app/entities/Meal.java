package com.springboot.app.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class Meal {
    private String mealId;
    private Date date;
    private String userId;
}
