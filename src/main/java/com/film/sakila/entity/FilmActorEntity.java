package com.film.sakila.entity;

import com.film.sakila.entity.composite.id.FilmActorId;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "film_actor")
@Data
public class FilmActorEntity{
    @EmbeddedId
    private FilmActorId id;

    @ManyToOne
    @MapsId("actorId")
    @JoinColumn(name = "actor_id")
    private ActorEntity actor;

    @ManyToOne
    @MapsId("filmId")
    @JoinColumn(name = "film_id")
    private FilmEntity film;

    @Column(name = "lastUpdate")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

}
