package com.film.sakila.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "city")
@Data
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cityId;

    @Column(name = "city")
    private String city;

    @Column(name = "countryId")
    private int countryId;

    @Column(name = "lastUpdate")
    private Timestamp lastUpdate;
}
