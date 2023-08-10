package com.film.sakila.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "customer")
@Data
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    @Column(name = "storeId")
    private int storeId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "addressId")
    private int addressId;

    @Column(name = "active")
    private int active;

    @Column(name = "createDate")
    @CreationTimestamp
    private Date createDate;

    @Column(name = "lastUpdate")
    @UpdateTimestamp
    private Timestamp lastUpdate;
}
