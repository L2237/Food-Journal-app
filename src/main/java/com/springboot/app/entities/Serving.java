package com.springboot.app.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "meal_servings")
public class Serving {

    @Id
    @Column(name = "serving_id")
    private Integer servingId;

    @ManyToOne
    @JoinColumn(name="food_item", referencedColumnName = "food_id", insertable = false, updatable = false)
    private FoodItem foodItem;

    @Column(name = "quantity")
    private Double quantity;
}
