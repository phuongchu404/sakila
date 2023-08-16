package com.film.sakila.entity;

import com.film.sakila.entity.enumtype.FilmEnum;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.Year;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "film")
@Data
public class FilmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "filmId")
    private int id;

    @Column(name = "title", length = 128)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "releaseYear")
    private Year releaseYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "languageId")
    private LanguageEntity language;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "originalLanguageId")
    private LanguageEntity originalLanguage;

    @Column(name = "rentalDuration")
    private int rentalDuration;

    @Column(name = "rentalRate")
    private double rentalRate;

    @Column(name = "length")
    private int length;

    @Column(name = "replacementCost")
    private double replacementCost;

    @Column(name = "rating")
    @Enumerated(EnumType.STRING)
    private FilmEnum rating;

//    @Column(name = "specialFeatures")
//    private

    @Column(name = "lastUpdate")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
}
