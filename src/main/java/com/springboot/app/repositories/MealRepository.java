package com.springboot.app.repositories;

import com.springboot.app.entities.Meal;
import com.springboot.app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Integer> {

    List<Meal> findMealsByUser(final User user);
}
