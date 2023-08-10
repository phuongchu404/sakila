package com.film.sakila.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "inventory")
@Data
public class InventoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inventoryId;

    @Column(name = "filmId")
    private int filmId;

    @Column(name = "storeId")
    private int storeId;

    @Column(name = "lastUpdate")
    private Timestamp lastUpdate;

}
