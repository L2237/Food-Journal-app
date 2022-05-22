package com.springboot.app.entities;

import com.springboot.app.entities.enums.MealType;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "meals")
public class Meal {

    @Id
    @Column(name = "meal_id")
    private Integer mealId;

    @Column(name = "meal_type")
    private MealType mealType;

    @Column(name = "meal_date")
    private Date meal_date;

    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Serving> servings;

}
