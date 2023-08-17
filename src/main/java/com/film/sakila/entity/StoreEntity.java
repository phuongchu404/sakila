package com.film.sakila.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "store")
@Data
public class StoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "storeId")
    private int id;

    @ManyToOne
    @JoinColumn(name = "manager_staff_id")
    private StaffEntity staff;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressEntity address;

    @Column(name = "lastUpdate")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

}
