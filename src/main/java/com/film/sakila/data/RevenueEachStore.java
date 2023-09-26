package com.film.sakila.data;

import lombok.Data;

@Data
public class RevenueEachStore {
    private int storeId;
    private String address;
    private Double revenue;

    public RevenueEachStore(int storeId, String address, String district, String city, String country, Double revenue){
        this.storeId = storeId;
        this.address = address+", "+ district +", " + city+", "+country;
        this.revenue = revenue;
    }
}
