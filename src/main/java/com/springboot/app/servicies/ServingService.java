package com.springboot.app.servicies;

import com.springboot.app.entities.FoodItem;
import com.springboot.app.entities.Serving;
import com.springboot.app.entities.dto.ServingDTO;
import com.springboot.app.repositories.FoodItemRepository;
import com.springboot.app.repositories.ServingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServingService {

    @Autowired
    private ServingRepository servingRepository;

    @Autowired
    private FoodItemRepository foodItemRepository;

    public List<Serving> getServings() {
        return servingRepository.findAll();
    }

    public void addServing(final ServingDTO servingDTO) {
       final Serving serving = new Serving();
       final FoodItem foodItem = new FoodItem();

       if(servingDTO.getFoodItem() != null) {
           // search food item in DB
           final Optional<FoodItem> foodItemFromDB = foodItemRepository.findByFoodName(servingDTO.getFoodItem().getFoodName());
           if(foodItemFromDB.isPresent()) {
               foodItem.setFoodName(foodItemFromDB.get().getFoodName());
               foodItem.setCalories(foodItemFromDB.get().getCalories());
               foodItem.setUnit(foodItemFromDB.get().getUnit());
           } else {
               // create a new food item if it doesn't exist in DB
               final FoodItem foodItemDTO = servingDTO.getFoodItem();
               foodItem.setFoodName(foodItemDTO.getFoodName());
               foodItem.setCalories(foodItemDTO.getCalories());
               foodItem.setUnit(foodItemDTO.getUnit());

               foodItemRepository.save(foodItem);
           }
       }

       serving.setFoodItem(foodItem);
       serving.setCaloriesPerServing(calculateCaloriesPerServing(foodItem.getCalories(), servingDTO.getQuantity()));

       servingRepository.save(serving);
    }

    private Double calculateCaloriesPerServing(final Integer calories, final Double quantity) {
        System.out.println("Calories:" + calories);
        System.out.println("Quantity:" + quantity);
        return  calories * quantity;
    }

}