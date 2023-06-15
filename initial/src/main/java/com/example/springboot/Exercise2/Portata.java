package com.example.springboot.Exercise2;

public class Portata {

    private String name;
    private String description;
    private double price;

    public Portata(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Portata() {
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price;
    }
}
