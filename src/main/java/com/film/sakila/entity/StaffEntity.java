package com.film.sakila.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Blob;
import java.util.Date;

@Entity
@Table(name = "staff")
@Data
public class StaffEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staffId")
    private int id;

    @Column(name = "firstName", length = 45)
    private String firstName;

    @Column(name = "lastName", length = 45)
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressEntity address;

    @Lob
    @Column(name = "picture", columnDefinition = "BLOB")
    private byte[] picture;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private StoreEntity store;

    @Column(name = "active")
    private int active;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "lastUpdate")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

}
