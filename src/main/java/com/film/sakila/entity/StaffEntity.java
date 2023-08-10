package com.film.sakila.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Blob;

@Entity
@Table(name = "staff")
@Data
public class StaffEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int staffId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "addressId")
    private int addressId;

    @Column(name = "picture")
    @Lob
    private Blob picture;
}
