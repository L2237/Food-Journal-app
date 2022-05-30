package com.springboot.app.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "meal_servings")
public class Serving {

    @Id
    @Column(name = "serving_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer servingId;

    @ManyToOne
    @JoinColumn(name="food_item", referencedColumnName = "food_id")
    private FoodItem foodItem;

    @Column(name = "quantity")
    private Double quantity;

    private Double caloriesPerServing;

}
