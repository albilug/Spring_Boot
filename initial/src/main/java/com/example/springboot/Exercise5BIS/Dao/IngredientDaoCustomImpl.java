package com.example.springboot.Exercise5BIS.Dao;
import com.example.springboot.Exercise5BIS.Model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class IngredientDaoCustomImpl implements IngredientDaoCustom{
    private IngredientDao ingredientDao;
    @Autowired
    public IngredientDaoCustomImpl(@Lazy IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }
    @Override
    public void updateById(Ingredient ingredient, Long ingredientId){
        Ingredient ingredientRepo = ingredientDao.findById(ingredientId).orElseThrow(NoSuchElementException::new);
        ingredientRepo.setName(ingredient.getName());
        ingredientRepo.setIsGlutenFree(ingredient.isGlutenFree());
        ingredientRepo.setIsVegetarian(ingredient.isVegetarian());
        ingredientRepo.setIsVegan(ingredient.isVegan());
        ingredientRepo.setIsLactoseFree(ingredient.isLactoseFree());

        ingredientDao.save(ingredientRepo);
    }
}
