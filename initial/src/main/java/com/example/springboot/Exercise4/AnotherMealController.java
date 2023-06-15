package com.example.springboot.Exercise4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnotherMealController {
    private AnotherMealService anotherMealService;
    private AnotherMealConfig anotherMealConfig;
    @Autowired
    public AnotherMealController(AnotherMealService anotherMealService, AnotherMealConfig anotherMealConfig){
        this.anotherMealService = anotherMealService;
        this.anotherMealConfig = anotherMealConfig;
    }

    @GetMapping("/another-meal")
    public ResponseEntity<List<AnotherMeal>> getAnotherMeals() {
        return ResponseEntity.ok(anotherMealService.getAnotherMeals());
    }

    @GetMapping("/another-meal-config")
    public ResponseEntity<AnotherMealConfig> getAnotherMealConfig() {
        return ResponseEntity.ok(anotherMealConfig);
    }

    @PostMapping("/another-meal")
    public ResponseEntity<String> addAnotherMeal(@RequestBody AnotherMeal am) {
        anotherMealService.addAnotherMeal(am);
        return ResponseEntity.ok("Another Meal added!");
    }

    @PutMapping("/another-meal")
    public ResponseEntity<String> updateAnotherMeal(@RequestBody AnotherMeal am) {
        anotherMealService.updateAnotherMeal(am);
        return ResponseEntity.ok("Another Meal updated!");
    }

    @DeleteMapping("/another-meal")
    public ResponseEntity<String> removeAnotherMeal(@RequestParam("name") String name){
        anotherMealService.removeAnotherMeal(name);
        return ResponseEntity.ok("Another Meal removed.");
    }
}
