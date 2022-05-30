package com.springboot.app.servicies;

import com.springboot.app.entities.FoodItem;
import com.springboot.app.entities.Meal;
import com.springboot.app.entities.Serving;
import com.springboot.app.entities.dto.ServingDTO;
import com.springboot.app.repositories.FoodItemRepository;
import com.springboot.app.repositories.MealRepository;
import com.springboot.app.repositories.ServingRepository;
import com.springboot.app.utils.MD5Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
@RequiredArgsConstructor
public class ServingService {

    private final ServingRepository servingRepository;
    private final MealRepository mealRepository;
    private final FoodItemRepository foodItemRepository;

    public List<Serving> getServings() {
        List<Serving> servings = servingRepository.findAll();
        for(Serving serving: servings) {
            serving.getMealId().getUser().setPassword(MD5Utils.bytesToHex(MD5Utils.digest(serving.getMealId().getUser().getPassword().getBytes(UTF_8))));
            serving.setCaloriesPerServing(calculateCaloriesPerServing(serving.getFoodItem().getCalories(), serving.getQuantity()));
        }

        return servings;
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
               foodItem.setFoodId(foodItemFromDB.get().getFoodId());
           } else {
               // create a new food item if it doesn't exist in DB
               final FoodItem foodItemDTO = servingDTO.getFoodItem();
               foodItem.setFoodName(foodItemDTO.getFoodName());
               foodItem.setCalories(foodItemDTO.getCalories());
               foodItem.setUnit(foodItemDTO.getUnit());

               foodItemRepository.save(foodItem);
               final Optional<FoodItem> foodItemSaveFromDB= foodItemRepository.findByFoodName(servingDTO.getFoodItem().getFoodName());
               foodItem.setFoodId(foodItemSaveFromDB.get().getFoodId());
           }
       }

       final Optional<Meal> mealFromDB = mealRepository.findById(servingDTO.getMeal().getMealId());
       serving.setMealId(mealFromDB.get());

       serving.setFoodItem(foodItem);
       serving.setQuantity(servingDTO.getQuantity());
       serving.setCaloriesPerServing(calculateCaloriesPerServing(foodItem.getCalories(), servingDTO.getQuantity()));

       servingRepository.save(serving);
    }

    private Double calculateCaloriesPerServing(final Double calories, final Double quantity) {
        return  calories * quantity;
    }

}