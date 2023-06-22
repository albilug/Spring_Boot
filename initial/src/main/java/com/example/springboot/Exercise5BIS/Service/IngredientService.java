package com.example.springboot.Exercise5BIS.Service;

import com.example.springboot.Exercise5BIS.Dao.IngredientDao;
import com.example.springboot.Exercise5BIS.Model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class IngredientService {
    private IngredientDao ingredientDao;
    @Autowired
    public IngredientService(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredientDao.save(ingredient);
    }

    public Ingredient getIngredient(Long ingredientId) {
        return ingredientDao.findById(ingredientId).orElse(null);
    }

    public void updateIngredient(Ingredient ingredient, Long ingredientId) throws SQLException {
        ingredientDao.updateById(ingredient, ingredientId);
    }

    public void deleteIngredient(Long ingredientId) {
        ingredientDao.deleteById(ingredientId);
    }
}
