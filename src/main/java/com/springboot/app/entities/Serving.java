package com.springboot.app.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "servings")
public class Serving {

    @Id
    @Column(name = "serving_id")
    private String servingId;

    @Column(name = "food_item_id")
    private String foodItemId;

    @Column(name = "meal_id")
    private String mealId;

    @Column(name = "quantity")
    private Double quantity;
}
