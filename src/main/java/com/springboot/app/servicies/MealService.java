package com.springboot.app.servicies;

import com.springboot.app.entities.Meal;
import com.springboot.app.entities.User;
import com.springboot.app.entities.dto.MealDTO;
import com.springboot.app.repositories.MealRepository;
import com.springboot.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Meal> getMeals() {
        return mealRepository.findAll();
    }

    public List<Meal> getMealsPerUserId(final Integer userId) throws Exception {
        final User user = userRepository.findById(userId) .orElseThrow(() ->
                new Exception("User id: " + userId + " does not exist in DB!"));
        return mealRepository.findMealsByUser(user);
    }

    public void addMeal(final MealDTO mealDTO) throws Exception {
        System.out.println(mealDTO);
        final User user = userRepository.findById(mealDTO.getUserId()) .orElseThrow(() ->
                new Exception("User id: " + mealDTO.getUserId() + " does not exist in DB!"));

        final Meal mealToSaveInDB = new Meal();
        mealToSaveInDB.setMealType(mealDTO.getMealType());
        mealToSaveInDB.setMealTime(mealDTO.getMealTime());
        mealToSaveInDB.setUser(user);

        mealRepository.save(mealToSaveInDB);
    }
}
