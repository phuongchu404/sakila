package com.film.sakila.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "language")
@Data
public class LanguageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int languageId;

    @Column(name = "name")
    private String name;

    @Column(name = "lastUpdate")
    private Timestamp lastUpdate;
}
