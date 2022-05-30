package com.springboot.app.repositories;


import com.springboot.app.entities.Meal;
import com.springboot.app.entities.Serving;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServingRepository extends JpaRepository<Serving, Integer> {

    List<Serving> findByMealId(Meal meal);

}
