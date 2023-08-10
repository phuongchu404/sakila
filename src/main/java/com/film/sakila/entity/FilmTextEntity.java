package com.film.sakila.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "film_text")
@Data
public class FilmTextEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int filmId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;
}
