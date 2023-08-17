package com.film.sakila.dto;

import com.film.sakila.entity.CityEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Base64;
import java.util.Date;
@Data
public class AddressDto {

    private int id;
    private String address;

    private String address2;
    private String district;
    private int cityId;
    private String postalCode;
    private String phone;
    private String location;
    private Date lastUpdate;


    public AddressDto(int id, String address, String address2, String district, int cityId,
                      String postalCode, String phone, byte[] location, Date lastUpdate) {
        this.id = id;
        this.address = address;
        this.address2 = address2;
        this.district = district;
        this.cityId = cityId;
        this.postalCode = postalCode;
        this.phone = phone;
        this.location = new String(decodeData(location));
        this.lastUpdate = lastUpdate;
    }

    private byte[] decodeData(byte[] encodedData){
        return Base64.getDecoder().decode(encodedData);
    }

}
