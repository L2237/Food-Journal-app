package com.springboot.app.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "meal")
public class Meal {

    @Id
    @Column(name = "meal_Id")
    private String mealId;

    @Column(name = "date")
    private Date date;

    @Column(name = "user_Id")
    private String userId;
}
