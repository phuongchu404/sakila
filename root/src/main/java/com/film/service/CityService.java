package com.film.service;

import com.film.dto.CityDto;
import com.film.entity.City;
import org.springframework.data.domain.Page;

public interface CityService {
    Page<CityDto> getAll(int pageNo, int pageSize);
}
