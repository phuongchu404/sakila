package com.film.sakila.service;

import com.film.sakila.dto.StaffDto;
import com.film.sakila.entity.StaffEntity;

import java.util.List;

public interface StaffService {
    List<StaffDto> getAll();
}
