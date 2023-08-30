package com.film.sakila.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class StaffCreationRequest {
    private String firstName;
    private String lastName;
    private int addressId;
    private int storeId;
    private String userName;
    @JsonIgnore
    private byte[] picture;
}
