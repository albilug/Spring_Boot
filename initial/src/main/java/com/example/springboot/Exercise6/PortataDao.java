package com.example.springboot.Exercise6;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortataDao extends JpaRepository<Portata, Integer> {
    List<Portata> findByDescription(String description);
    List<Portata> findByPriceLessThan(Double price);
    List<Portata> findByPriceBetween(Double minPrice, Double maxPrice);
    List<Portata> findByDescriptionAndPriceLessThan(String description, Double price);

    List<Portata> findByDescriptionContains(String parolaChiave);
    List<Portata> findByPriceLessThanAndCaloriesGreaterThanOrCaloriesLessThan(Double maxPrice, Integer minCalories, Integer maxCalories);

    List<Portata> findByIsWinterMeal(boolean isWinterMeal);
}
