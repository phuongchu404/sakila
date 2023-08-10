package com.film.sakila.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CurrentTimestamp;

import java.sql.Timestamp;

@Entity
@Data
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;

    @Column(name = "address")
    private String address;

    @Column(name = "address2")
    private String address2;

    @Column(name = "district")
    private String district;

    @Column(name = "cityId")
    private int cityId;

    @Column(name = "postalCode")
    private String postalCode;

    @Column(name = "phone")
    private String phone;

//    @Column(name = "location")
//    private Geomery
    @Column(name = "lastUpdate")
    private Timestamp lastUpdate;
}
