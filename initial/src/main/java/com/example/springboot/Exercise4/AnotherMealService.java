package com.example.springboot.Exercise4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnotherMealService {
    private AnotherMealDao anotherMealDao;
    @Autowired
    public AnotherMealService(AnotherMealDao anotherMealDao) {
        this.anotherMealDao = anotherMealDao;
    }

    public void addAnotherMeal(AnotherMeal am) {
        anotherMealDao.addAnotherMeal(am);
    }

    public void removeAnotherMeal(String name) {
        anotherMealDao.removeAnotherMeal(name);
    }

    public void updateAnotherMeal(AnotherMeal am) {
        anotherMealDao.updateAnotherMeal(am);
    }

    public List<AnotherMeal> getAnotherMeals() {
        return anotherMealDao.getAnotherMeals();
    }
}
