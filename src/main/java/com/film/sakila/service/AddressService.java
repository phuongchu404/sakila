package com.film.sakila.service;

import com.film.sakila.dto.AddressDto;
import com.film.sakila.entity.AddressEntity;

import java.util.List;

public interface AddressService {

    List<AddressDto> getAll();

}
