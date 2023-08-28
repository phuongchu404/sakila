package com.film.sakila.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.film.sakila.dto.CityDto;
import com.film.sakila.entity.City;
import com.film.sakila.repository.CityRepository;
import com.film.sakila.service.CityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Page<CityDto> getAll(int pageNo, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, Sort.by("id").descending());
        Page<City> cities = cityRepository.findAll(pageRequest);
        return cities.map(this::convertToDto);
//        List<CityDto> cityDtos = cityRepository.findAll(pageRequest).stream()
//                .map(this::convertToDto).collect(Collectors.toList());
//        return cityDtos;

    }

    private CityDto convertToDto(City city){
        CityDto cityDto = modelMapper.map(city, CityDto.class);
        return cityDto;
    }

    private City convertToEntity(CityDto cityDto){
        City city = modelMapper.map(cityDto, City.class);
        return city;
    }
}
