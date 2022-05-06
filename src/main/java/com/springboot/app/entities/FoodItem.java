package com.springboot.app.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="food_items")
@RequiredArgsConstructor
public class FoodItem {
    @Id
    @Column(name = "food_id")
    private String foodItemId;

    @Column(name = "food_name")
    private String name;

    @Column(name = "calories")
    private Integer calories;

    @Column(name = "quantity")
    private Double quantity;

}
