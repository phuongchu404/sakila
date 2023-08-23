package com.film.sakila.dto;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;
import java.util.Set;

@Data
public class FilmDto {
    private int id;
    private String title;
    private String description;
    private Year releaseYear;
    private int languageId;
    private int rentalDuration;
    private double rentalRate;
    private int length;
    private double replacementCost;
    private String rating;
    private Set<String> specialFeatures;
    private String lastUpdate;
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public FilmDto(int id, String title, String description, Year releaseYear, int languageId, int rentalDuration, double rentalRate, int length, double replacementCost, String rating, Set<String> specialFeatures, Date lastUpdate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.languageId = languageId;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.length = length;
        this.replacementCost = replacementCost;
        this.rating = rating;
        this.specialFeatures = specialFeatures;
        this.lastUpdate = simpleDateFormat.format(lastUpdate);
    }
}
