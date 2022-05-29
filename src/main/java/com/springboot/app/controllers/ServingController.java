package com.springboot.app.controllers;

import com.springboot.app.entities.FoodItem;
import com.springboot.app.entities.Meal;
import com.springboot.app.entities.Serving;
import com.springboot.app.entities.dto.ServingDTO;
import com.springboot.app.servicies.MealService;
import com.springboot.app.servicies.ServingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServingController {

    @Autowired
    private ServingService servingService;

    @GetMapping(value = "/getServings")
    private List<Serving> getServings() {
        return servingService.getServings();
    }

    @PostMapping(value = "/addServing")
    public void addServing(@RequestBody ServingDTO servingDTO) {
        servingService.addServing(servingDTO);
    }

}
