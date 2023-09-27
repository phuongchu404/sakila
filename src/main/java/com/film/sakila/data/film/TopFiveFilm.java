package com.film.sakila.data.film;

import com.film.sakila.status.RatingEnum;
import com.film.sakila.status.SpecialFeatureEnum;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class TopFiveFilm {
    private int id;
    private String title;
    private String description;
    private long releaseYear;
    private int languageId;
    private int rentalDuration;
    private double rentalRate;
    private int length;
    private double replacementCost;
    private String rating;
    private Set<String> specialFeatures;
    private String lastUpdate;
    private long count;
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public TopFiveFilm(int id, String title, String description, Year releaseYear, int languageId, int rentalDuration,
                       double rentalRate, int length, double replacementCost, RatingEnum rating, Set<SpecialFeatureEnum> specialFeatures,
                       Date lastUpdate, long count) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear.getValue();
        this.languageId = languageId;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.length = length;
        this.replacementCost = replacementCost;
        this.rating = rating.getValue();
        this.specialFeatures = specialFeatures.stream().map(SpecialFeatureEnum::getValue).collect(Collectors.toSet());
        this.lastUpdate = simpleDateFormat.format(lastUpdate);
        this.count = count;
    }
}
