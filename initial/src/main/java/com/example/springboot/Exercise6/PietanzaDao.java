package com.example.springboot.Exercise6;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PietanzaDao extends JpaRepository<Pietanza, Integer> {
    List<Pietanza> findByDescription(String description);
    List<Pietanza> findByPriceLessThan(Double price);
    List<Pietanza> findByPriceBetween(Double minPrice, Double maxPrice);
    List<Pietanza> findByDescriptionAndPriceLessThan(String description, Double price);

    List<Pietanza> findByDescriptionContains(String parolaChiave);
    List<Pietanza> findByPriceLessThanAndCaloriesGreaterThanOrCaloriesLessThan(Double maxPrice, Integer minCalories, Integer maxCalories);

    List<Pietanza> findByIsWinterMeal(boolean isWinterMeal);
}
