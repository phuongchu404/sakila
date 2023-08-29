package com.film.sakila.service;

import com.film.sakila.data.AverageRentalByCategory;
import com.film.sakila.data.TopFiveFilm;
import com.film.sakila.dto.FilmDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;

public interface FilmService {
    List<FilmDto> getTitleRateCost();
    void insert(String title, int languageId, String rating, Set<String> specialFeature);
    List<TopFiveFilm> getTopFiveFilm();

    List<AverageRentalByCategory> averageRentalByCategory(int pageNo, int pageSize);

}
