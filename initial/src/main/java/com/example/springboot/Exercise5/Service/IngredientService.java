package com.example.springboot.Exercise5.Service;

import com.example.springboot.Exercise5.DAO.IngredientDao;
import com.example.springboot.Exercise5.Model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService  {
    private IngredientDao ingredientDao;

    @Autowired
    public IngredientService(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }

    public void addIngredient(Ingredient dumpling) {
        ingredientDao.save(dumpling);
    }
}
