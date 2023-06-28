package com.example.springboot.Exercise6;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pietanza {
    @Id
    private Integer id;
    private String name;
    private String description;
    private double price;
    private Integer calories;
    private boolean isWinterMeal;

    public Pietanza(String name, String description, double price, Integer calories, boolean isWinterMeal) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.calories = calories;
        this.isWinterMeal = isWinterMeal;
    }

    public Pietanza() {}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Integer getCalories() { return calories; }
    public void setCalories(Integer calories) { this.calories = calories; }
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public boolean getIsWinterMeal() { return isWinterMeal; }
    public void setIsWinterMeal(boolean isWinterMeal) { this.isWinterMeal = isWinterMeal; }
}
