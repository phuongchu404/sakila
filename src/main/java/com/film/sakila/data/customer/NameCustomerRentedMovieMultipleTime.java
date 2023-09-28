package com.film.sakila.data.customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NameCustomerRentedMovieMultipleTime {
    private String fullName;
    private Long numberOfRental;
    public NameCustomerRentedMovieMultipleTime(String firstName, String lastName, Long numberOfRental){
        this.fullName = firstName + " " + lastName;
        this.numberOfRental = numberOfRental;
    }
}
