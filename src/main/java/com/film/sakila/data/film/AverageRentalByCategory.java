package com.film.sakila.data.film;

import lombok.Data;

@Data
public class AverageRentalByCategory {
    private String categoryName;
    private double avgRental;
    public AverageRentalByCategory(String categoryName, double avgRental){
        this.categoryName = categoryName;
        this.avgRental =avgRental;
    }
}
