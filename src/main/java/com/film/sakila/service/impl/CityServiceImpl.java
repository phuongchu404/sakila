package com.film.sakila.service.impl;

import com.film.sakila.entity.City;
import com.film.sakila.repository.CityRepository;
import com.film.sakila.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;
    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }
}
