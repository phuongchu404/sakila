package com.film.service;

import com.film.data.film.AverageRentalByCategory;
import com.film.data.film.TopFiveFilm;
import com.film.dto.FilmDto;
import com.film.entity.Film;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;

public interface FilmService {
    List<FilmDto> getTitleRateCost();
    void insert(String title, int languageId, String rating, Set<String> specialFeature);
    List<TopFiveFilm> getTopFiveFilm();

    List<AverageRentalByCategory> averageRentalByCategory(int pageNo, int pageSize);

    List<String> getTitleFilm(int length);

    List<String> getTitleNotReturnDate();

    List<String> getTitleRentedByMultipleCustomer(int count);

    Page<Film> getAll(int pageNo, int pageSize, String sortBy);

}
