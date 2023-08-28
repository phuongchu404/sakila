package com.film.sakila.service;

import com.film.sakila.dto.CityDto;
import com.film.sakila.entity.City;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CityService {
    Page<CityDto> getAll(int pageNo, int pageSize);
}
