package com.example.springboot.Exercise5BIS.Dao;

import com.example.springboot.Exercise5BIS.Model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientDao extends JpaRepository<Ingredient, Long>, IngredientDaoCustom{
}
