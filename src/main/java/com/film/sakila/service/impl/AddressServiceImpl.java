package com.film.sakila.service.impl;

import com.film.sakila.dto.AddressDto;
import com.film.sakila.repository.AddressRepository;
import com.film.sakila.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<AddressDto> getAll() {
        return addressRepository.findAll().stream().map(item-> {
            try {
                return new AddressDto(item.getId(), item.getAddress(), item.getAddress2(),
                        item.getDistrict(), item.getCity().getId(), item.getPostalCode(), item.getPhone(), item.getLastUpdate());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
    }
}
