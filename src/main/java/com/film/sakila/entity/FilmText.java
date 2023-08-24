package com.film.sakila.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "film_text")
@Data
public class FilmText{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "filmId")
    private int id;

    @Column(name = "title", length = 255)
    private String title;

    @Column(name = "description")
    private String description;
}
