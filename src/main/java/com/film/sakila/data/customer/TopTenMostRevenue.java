package com.film.sakila.data.customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopTenMostRevenue {
    private String fullName;
    private double revenue;

    public TopTenMostRevenue(String firstName, String lastName, double revenue){
        this.fullName = firstName + " " + lastName;
        this.revenue = revenue;
    }
}
