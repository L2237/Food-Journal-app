package com.springboot.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name="meal_id", referencedColumnName = "meal_id")
    private Meal mealId;

    @Column(name = "quantity")
    private Double quantity;

    @Column(name = "calories_per_serving")
    private Double caloriesPerServing;

}
