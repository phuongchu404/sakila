package com.film.sakila.dto;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Base64;
import java.util.Date;
@Data
public class CustomerDto {
    private int id;
    private int storeId;
    private String firstName;
    private String lastName;
    private String email;
    private int addressId;
    private int active;
    private Date createDate;
    private Date lastUpdate;

    private byte[] decodeData(byte[] encodedData){
        return Base64.getDecoder().decode(encodedData);
    }
}
