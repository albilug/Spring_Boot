package com.example.springboot.Exercise5BIS.Model;

import jakarta.persistence.*;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column (name = "isVegeterian")
    private boolean isVegetarian;
    @Column (name = "isVegan")
    private boolean isVegan;
    @Column (name = "isGlutenFree")
    private boolean isGlutenFree;
    @Column (name = "isLactoseFree")
    private boolean isLactoseFree;

    public Ingredient(String name, boolean isVegetarian, boolean isVegan, boolean isGlutenFree, boolean isLactoseFree) {
        this.setName(name);
        this.setIsVegetarian(isVegetarian);
        this.setIsVegan(isVegan);
        this.setIsGlutenFree(isGlutenFree);
        this.setIsLactoseFree(isLactoseFree);
    }

    public Ingredient() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void setIsVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setIsVegan(boolean vegan) {
        isVegan = vegan;
    }

    public boolean isGlutenFree() {
        return isGlutenFree;
    }

    public void setIsGlutenFree(boolean glutenFree) {
        isGlutenFree = glutenFree;
    }

    public boolean isLactoseFree() {
        return isLactoseFree;
    }

    public void setIsLactoseFree(boolean lactoseFree) {
        isLactoseFree = lactoseFree;
    }
}
