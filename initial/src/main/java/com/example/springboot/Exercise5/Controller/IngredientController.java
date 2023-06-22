package com.example.springboot.Exercise5.Controller;

import com.example.springboot.Exercise5.Model.Ingredient;
import com.example.springboot.Exercise5.Model.Meal;
import com.example.springboot.Exercise5.Service.IngredientService;
import com.example.springboot.Exercise5.Service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IngredientController {
    private IngredientService ingredientService;
    private MealService mealService;

    @Autowired
    public IngredientController(IngredientService ingredientService, MealService mealService) {
        this.ingredientService = ingredientService;
        this.mealService = mealService;
    }

    @PutMapping("/add-ingredient")
    public ResponseEntity<Meal> addMeal() {
        return ResponseEntity.ok().build();
    }

}
