package com.film.sakila.entity;

import com.film.sakila.entity.compositeId.FilmActorId;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "film_actor")
@Data
public class FilmActorEntity {
    @EmbeddedId
    private FilmActorId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("actorId")
    private ActorEntity actorId;

}
