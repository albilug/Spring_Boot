package com.example.springboot.Exercise5.DAO;

import com.example.springboot.Exercise5.Model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientDao extends JpaRepository<Ingredient, Long> {}
