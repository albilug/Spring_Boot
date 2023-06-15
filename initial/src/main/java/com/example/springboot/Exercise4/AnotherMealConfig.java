package com.example.springboot.Exercise4;

import org.springframework.stereotype.Component;

@Component
public class AnotherMealConfig {
    private Integer minAge = 18;
    private Double maxPrice = 25.0;

    public AnotherMealConfig() {}
    public void setMinAge(Integer age) {
        this.minAge = age;
    }

    public void setMaxPrice(Double price) {
        this.maxPrice = price;
    }

    public Integer getMinAge()  {
        return minAge;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }
}
