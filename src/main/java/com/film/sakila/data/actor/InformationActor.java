package com.film.sakila.data.actor;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InformationActor {
    private String firstName;
    private String lastName;


    public InformationActor(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
