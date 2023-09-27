package com.film.sakila.service.impl;

import com.film.sakila.dto.AddressDto;
import com.film.sakila.entity.Address;
import com.film.sakila.entity.City;
import com.film.sakila.repository.AddressRepository;
import com.film.sakila.repository.CityRepository;
import com.film.sakila.service.AddressService;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.WKTReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CityRepository cityRepository;
    public static Geometry wktToGeometry(String wellKnowText) throws org.locationtech.jts.io.ParseException {
        return new WKTReader().read(wellKnowText);
    }
    @Override
    public List<AddressDto> getAll() {
        return addressRepository.findAll().stream().map(item-> {
            try {
                return new AddressDto(item.getId(), item.getAddress(), item.getAddress2(),
                        item.getDistrict(), item.getCity().getId(), item.getPostalCode(), item.getPhone(),item.getLocation(), item.getLastUpdate());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public void insert(String address, String district, int cityId, String phone, String location) throws org.locationtech.jts.io.ParseException {
        City city = cityRepository.findById(cityId).get();
        Address addressEntity = new Address();
        addressEntity.setCity(city);
        addressEntity.setAddress(address);
        addressEntity.setDistrict(district);
        addressEntity.setPhone(phone);
        addressEntity.setLocation((Point) wktToGeometry(location));
        addressRepository.save(addressEntity);
    }
}
