package com.film.sakila.entity;

import com.film.sakila.entity.compositeId.FilmCategoryId;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "film_category")
@Data
public class FilmCategoryEntity{

    @EmbeddedId
    private FilmCategoryId filmCategoryId;

    @ManyToOne
    @MapsId("filmId")
    @JoinColumn(name = "film_id")
    private FilmEntity film;

    @ManyToOne
    @MapsId("categoryId")
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @Column(name = "lastUpdate")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
}
