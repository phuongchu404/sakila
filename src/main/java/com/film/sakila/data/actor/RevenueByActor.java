package com.film.sakila.data.actor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RevenueByActor {
    private String fullName;
    private Double revenue;
    public RevenueByActor(String fullName, Double revenue){
        this.fullName = fullName;
        this.revenue = revenue;
    }
}
