package com.film.sakila.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "payment")
@Data
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;

    @Column(name = "customerId")
    private int customerId;

    @Column(name = "staffId")
    private int staffId;

    @Column(name = "rentalId")
    private int rentalId;

    @Column(name = "amount")
    private double amount;

    @Column(name = "paymentDate")
    private Date paymentDate;

    @Column(name = "lastUpdate")
    private Timestamp lastUpdate;
}
