package com.film.sakila.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "rental")
@Data
public class RentalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rentalId;

    @Column(name = "rentalDate")
    private Date rentalDate;

    @Column(name = "inventoryId")
    private int inventoryId;

    @Column(name = "customerId")
    private int customerId;

    @Column(name = "returnDate")
    private Date returnDate;

    @Column(name = "staffId")
    private int staffId;

    @Column(name = "lastUpdate")
    private Timestamp lastUpdate;
}
