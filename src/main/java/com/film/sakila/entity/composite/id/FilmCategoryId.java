package com.film.sakila.entity.composite.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class FilmCategoryId implements Serializable {

    @Column(name = "film_id")
    private int filmId;

    @Column(name = "categoryId")
    private int categoryId;
}
