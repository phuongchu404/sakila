package com.film.dto;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.text.SimpleDateFormat;
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
    private String createDate;
    private String lastUpdate;
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private byte[] decodeData(byte[] encodedData){
        return Base64.getDecoder().decode(encodedData);
    }

    public void setCreateDate(Date createDate){
        this.createDate = simpleDateFormat.format(createDate);
    }
    public void setLastUpdate(Date lastUpdate){
        this.lastUpdate = simpleDateFormat.format(lastUpdate);
    }
}
