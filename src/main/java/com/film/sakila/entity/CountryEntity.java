package com.film.sakila.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "country")
@Data
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int coutryId;

    @Column(name = "country")
    private String country;

    @Column(name = "lastUpdate")
    private Timestamp lastUpdate;
}
