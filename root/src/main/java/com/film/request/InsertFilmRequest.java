package com.film.request;

import lombok.Data;

import java.util.Set;

@Data
public class InsertFilmRequest {
    private String title;
    private int languageId;
    private String rating;
    private Set<String> specialFeature;
}
