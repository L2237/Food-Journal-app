package com.springboot.app.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="food_items")
@RequiredArgsConstructor
public class FoodItem {
    @Id
    @Column(name = "food_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer foodId;

    @Column(name = "food_name")
    private String foodName;

    @Column(name = "calories")
    private Double calories;

    @Column(name = "unit")
    private String unit;
}
