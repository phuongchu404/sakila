package com.film.data.customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRentalByCategory {
    private String fullName;
    private String address;
    private String email;
    private String categoryName;

    public CustomerRentalByCategory(String firstName, String lastName, String address, String district, String city,
                                                String country, String email, String categoryName){
        this.fullName = firstName+ " " + lastName;
        this.address = address + ", " + district + ", " + city + ", " + country;
        this.email = email;
        this.categoryName= categoryName;
    }
}
