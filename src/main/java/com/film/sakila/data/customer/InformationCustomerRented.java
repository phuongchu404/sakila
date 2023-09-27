package com.film.sakila.data.customer;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class InformationCustomerRented {
    private String name;
    private String address;
    private String paymentDate;
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public InformationCustomerRented(String firstName, String lastName, String address, String district, String city, String country, Date paymentDate) {
        this.name = firstName + " "+ lastName;
        this.address = address+", "+district+", "+city+", "+country;
        this.paymentDate = simpleDateFormat.format(paymentDate);
    }
}
