package com.film.sakila.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "store")
@Data
public class StoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int storeId;

    @Column(name = "managerStaffId")
    private int managerStaffId;

    @Column(name = "addressId")
    private int addressId;

    @Column(name = "lastUpdate")
    private Timestamp lastUpdate;
}
