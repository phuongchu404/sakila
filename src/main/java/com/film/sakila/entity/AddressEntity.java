package com.film.sakila.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

import java.util.Date;

@Entity
@Data
@Table(name = "address")
public class AddressEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addressId")
    private int id;

    @Column(name = "address", length = 50)
    private String address;

    @Column(name = "address2", length = 50)
    private String address2;

    @Column(name = "district", length = 20)
    private String district;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityEntity city;

    @Column(name = "postalCode", length = 10)
    private String postalCode;

    @Column(name = "phone", length = 20)
    private String phone;

//    @Column(name = "location", columnDefinition = "GEOMETRY")
//    private Geometry location;

    @Column(name = "location", columnDefinition = "GEOMETRY")
    private Point location;

    @Column(name = "lastUpdate")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;



}
