package com.example.springboot.Exercise4;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AnotherMealDao {
    private List<AnotherMeal> anotherMeals = new ArrayList<>();

    public void addAnotherMeal(AnotherMeal am) {
        anotherMeals.add(am);
    }

    public void removeAnotherMeal(String name) {
        List<AnotherMeal> tempList = anotherMeals.stream().filter(listAm -> listAm.getName().equals(name)).collect(Collectors.toList());
        if (tempList.size() == 1) {
            anotherMeals.remove(tempList.get(0));
        } else if (tempList.size() == 0) {
            System.out.println("Another Meal not found.");
        } else System.err.println("More thank one Another Meal found");
    }

    public void updateAnotherMeal(AnotherMeal am) {
        anotherMeals.removeIf(listAm -> listAm.getName().equals(am.getName()));
        anotherMeals.add(am);
    }

    public List<AnotherMeal> getAnotherMeals() {
        return this.anotherMeals;
    }
}
