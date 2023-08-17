package com.film.sakila.service.impl;

import com.film.sakila.entity.AddressEntity;
import com.film.sakila.entity.CityEntity;
import com.film.sakila.repository.AddressRepository;
import com.film.sakila.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Override
    public List<AddressEntity> getAll() {
        List<AddressEntity> list =  addressRepository.findAll();
        return addressRepository.findAll();
    }
}
