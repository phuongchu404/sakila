package com.film.sakila.entity;

import com.film.sakila.coverter.SpecialFeatureEnumConverter;
import com.film.sakila.status.RatingEnum;
import com.film.sakila.status.SpecialFeatureEnum;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Year;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "film")
@Data
public class FilmEntity{
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

    @ManyToOne
    @JoinColumn(name = "languageId")
    private LanguageEntity language;

    @ManyToOne
    @JoinColumn(name = "originalLanguageId")
    private LanguageEntity originalLanguage;

    @Column(name = "rentalDuration", columnDefinition = "TINYINT default 3")
    private int rentalDuration;

    @Column(name = "rentalRate", columnDefinition = "DECIMAL(4,2) default 4.99")
    private double rentalRate;

    @Column(name = "length")
    private int length;

    @Column(name = "replacementCost", columnDefinition = "DECIMAL(5,2) default 19.99")
    private double replacementCost;

    @Column(name = "rating", columnDefinition = "ENUM('G','PG','PG-13','R','NC-17') default 'G'")
    private RatingEnum rating = RatingEnum.NC_17;

    @Column(name = "specialFeatures", columnDefinition = "SET('Trailers', 'Commentaries', 'Deleted Scenes', 'Behind the Scenes')")
    private Set<SpecialFeatureEnum> specialFeatures;

    @Column(name = "lastUpdate")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;



}
