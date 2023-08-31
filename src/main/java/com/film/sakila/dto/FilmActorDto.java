package com.film.sakila.dto;

import lombok.Data;

import java.text.SimpleDateFormat;

@Data
public class FilmActorDto {
    private Integer id;
    private Integer actorId;
    private Integer filmId;
    private String lastUpdate;
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
