package com.film.sakila.entity.composite.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class FilmActorId implements Serializable {
    @Column(name = "actorId")
    private int actorId;

    @Column(name = "filmId")
    private int filmId;


}
