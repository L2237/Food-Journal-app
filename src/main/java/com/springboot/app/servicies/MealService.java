package com.springboot.app.servicies;

import com.springboot.app.entities.Meal;
import com.springboot.app.entities.Serving;
import com.springboot.app.entities.User;
import com.springboot.app.entities.dto.MealDTO;
import com.springboot.app.repositories.MealRepository;
import com.springboot.app.repositories.ServingRepository;
import com.springboot.app.repositories.UserRepository;
import com.springboot.app.utils.MD5Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
@RequiredArgsConstructor
public class MealService {

    private final MealRepository mealRepository;
    private final ServingRepository servingRepository;
    private final UserRepository userRepository;

    public List<Meal> getMeals() {
        List<Meal> meals  = mealRepository.findAll();
        meals.forEach(meal -> meal.getUser().setPassword(MD5Utils.bytesToHex(MD5Utils.digest(meal.getUser().getPassword().getBytes(UTF_8)))));
        meals.forEach(meal -> meal.setCaloriesPerMeal(calculateCaloriesPerMeal(meal)));
       return meals;
    }

    public List<Meal> getMealsPerUserId(final Integer userId) throws Exception {
        final User user = userRepository.findById(userId) .orElseThrow(() ->
                new Exception("User id: " + userId + " does not exist in DB!"));
        user.setPassword(MD5Utils.bytesToHex(MD5Utils.digest(user.getPassword().getBytes(UTF_8))));
        List<Meal> meals = mealRepository.findMealsByUser(user);
        meals.forEach(meal -> meal.setCaloriesPerMeal(calculateCaloriesPerMeal(meal)));
        return meals;
    }

    public void addMeal(final MealDTO mealDTO) throws Exception {
        final User user = userRepository.findById(mealDTO.getUserId()) .orElseThrow(() ->
                new Exception("User id: " + mealDTO.getUserId() + " does not exist in DB!"));

        final Meal mealToSaveInDB = new Meal();
        mealToSaveInDB.setMealType(mealDTO.getMealType());
        mealToSaveInDB.setMealTime(mealDTO.getMealTime());
        mealToSaveInDB.setUser(user);

        mealRepository.save(mealToSaveInDB);
    }

    private Double calculateCaloriesPerMeal(final Meal meal) {
        List<Serving> servings = servingRepository.findByMealId(meal);
        Double caloriesPerMeal = 0D;

        for(Serving serving: servings) {
            caloriesPerMeal = caloriesPerMeal + serving.getCaloriesPerServing();
        }
        return caloriesPerMeal;
    }

}
