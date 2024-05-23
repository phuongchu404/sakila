package com.film.data.store;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
