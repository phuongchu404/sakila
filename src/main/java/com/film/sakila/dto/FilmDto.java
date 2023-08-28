package com.film.sakila.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.film.sakila.common.Views;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmDto {

    private int id;

    @JsonView(Views.FilmTitleRateCost.class)
    private String title;

    private String description;

    private Year releaseYear;

    private int languageId;

    private int rentalDuration;

    @JsonView(Views.FilmTitleRateCost.class)
    private double rentalRate;

    private int length;

    @JsonView(Views.FilmTitleRateCost.class)
    private double replacementCost;

    private String rating;

    private Set<String> specialFeatures;

    private String lastUpdate;

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void  setLastUpdate(Date lastUpdate){
        this.lastUpdate = simpleDateFormat.format(lastUpdate);
    }
}
