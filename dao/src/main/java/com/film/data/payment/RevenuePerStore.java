package com.film.data.payment;

import lombok.Data;

@Data
public class RevenuePerStore {
    private String storeAddress;
    private String staffName;
    private byte[] staffImage;
    private double revenue;

    public RevenuePerStore(String address, String district, String city, String country, String firstName, String lastName, byte[] staffImage, double revenue) {
        this.storeAddress = address +", "+ district +", "+ city+ ", "+country;
        this.staffName = firstName+ " "+ lastName;
        this.staffImage = staffImage;
        this.revenue = revenue;
    }
}
