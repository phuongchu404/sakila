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
public class Film{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "filmId")
    private int id;

    @Column(name = "title", length = 128, nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "releaseYear")
    private Year releaseYear;

    @ManyToOne
    @JoinColumn(name = "languageId")
    private Language language;

    @ManyToOne
    @JoinColumn(name = "originalLanguageId")
    private Language originalLanguage;

    @Column(name = "rentalDuration", columnDefinition = "TINYINT default 3", nullable = false)
    private int rentalDuration=3;

    @Column(name = "rentalRate", columnDefinition = "DECIMAL(4,2) default 4.99", nullable = false)
    private double rentalRate=4.99;

    @Column(name = "length")
    private int length;

    @Column(name = "replacementCost", columnDefinition = "DECIMAL(5,2) default 19.99")
    private double replacementCost=19.99D;

    @Column(name = "rating", columnDefinition = "ENUM('G','PG','PG-13','R','NC-17') default 'G'")
    private RatingEnum rating = RatingEnum.G;

    @Column(name = "specialFeatures", columnDefinition = "SET('Trailers', 'Commentaries', 'Deleted Scenes', 'Behind the Scenes')")
    private Set<SpecialFeatureEnum> specialFeatures;

    @Column(name = "lastUpdate")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
}
