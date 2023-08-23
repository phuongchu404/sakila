package com.film.sakila.service;

import com.film.sakila.dto.FilmDto;
import com.film.sakila.entity.FilmEntity;

import java.util.List;
import java.util.Set;

public interface FilmService {
    List<String> getTitle();
    void insert(String title, int languageId, String rating, Set<String> specialFeature);

    List<FilmDto> getAll();
}
