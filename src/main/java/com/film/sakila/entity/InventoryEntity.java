package com.film.sakila.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "inventory")
@Data
public class InventoryEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventoryId")
    private int id;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private StoreEntity store;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private FilmEntity film;

    @Column(name = "lastUpdate")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;



}
