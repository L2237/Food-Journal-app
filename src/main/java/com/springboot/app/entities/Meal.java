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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mealId;

    @Column(name = "meal_type")
    @Enumerated(EnumType.STRING)
    private MealType mealType;

    @Column(name = "meal_time")
    private Date mealTime;

    @OneToMany
    private List<Serving> servings;

    @ManyToOne
    @JoinColumn(name="user", referencedColumnName = "user_id")
    private User user;



}
