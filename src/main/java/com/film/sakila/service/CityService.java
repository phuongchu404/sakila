package com.film.sakila.service;

import com.film.sakila.dto.CityDto;
import com.film.sakila.entity.City;

import java.util.List;

public interface CityService {
    List<CityDto> getAll();
}
