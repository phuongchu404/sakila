package com.film.sakila.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Year;

@Entity
@Table(name = "film")
@Data
public class FilmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int filmId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "releaseYear")
    private Year releaseYear;

    @Column(name = "languageId")
    private int languageId;

    @Column(name = "originalLanguageId")
    private int originalLanguageId;

    @Column(name = "rentalDuration")
    private int rentalDuration;

    @Column(name = "rentalRate")
    private Double rentalRate;

    @Column(name = "length")
    private int length;

    @Column(name = "replacementCost")
    private Double replacementCost;

//    @Column(name = "rating")
//    private
}
