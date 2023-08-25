package com.film.sakila.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.film.sakila.common.Views;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "city")
@Data
public class City{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cityId")
    private int id;

    @Column(name = "city", length = 50, nullable = false)
    private String city;

    @Column(name = "lastUpdate")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp lastUpdate;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}

