package com.film.sakila.service;

import com.film.sakila.dto.StaffDto;

import java.util.List;

public interface StaffService {
    List<StaffDto> getAll();
}
