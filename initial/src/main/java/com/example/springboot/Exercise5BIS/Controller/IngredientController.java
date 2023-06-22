package com.example.springboot.Exercise5BIS.Controller;

import com.example.springboot.Exercise5BIS.Service.IngredientService;
import com.example.springboot.Exercise5BIS.Model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping(value = "/api/ingredient/")
public class IngredientController {
    private IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping
    public ResponseEntity<?> addIngredient(@RequestBody Ingredient ingredient) {
        ingredientService.addIngredient(ingredient);
        return ResponseEntity.ok().build();
    }

    @GetMapping (value = "{ingredientId}")
    public ResponseEntity<Ingredient> getIngredient(@PathVariable("ingredientId") Long ingredientId) {
        return ResponseEntity.ok(ingredientService.getIngredient(ingredientId));
    }

    @PutMapping (value = "{ingredientId}")
    public ResponseEntity<?> updateIngredient(@PathVariable("ingredientId") Long ingredientId,
                                              @RequestBody Ingredient ingredient) throws SQLException {
        ingredientService.updateIngredient(ingredient, ingredientId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping (value = "{ingredientId}")
    public ResponseEntity<?> deleteIngredient(@PathVariable("ingredientId") Long ingredientId) {
        ingredientService.deleteIngredient(ingredientId);
        return ResponseEntity.ok().build();
    }
}
