package com.film.sakila.service;

import com.film.sakila.dto.AddressDto;
import com.film.sakila.entity.Address;
import org.locationtech.jts.io.ParseException;

import java.util.List;

public interface AddressService {

    List<AddressDto> getAll();
    List<Address> findAll();

    void insert(String address, String district, int cityId, String phone, String location) throws ParseException;

}
