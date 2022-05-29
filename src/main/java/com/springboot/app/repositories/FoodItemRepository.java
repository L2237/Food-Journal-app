package com.springboot.app.repositories;

import com.springboot.app.entities.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Integer>  {

    void deleteByFoodName(final String foodName);

    Optional<FoodItem> findByFoodName(final String foodName);
}
