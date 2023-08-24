package com.film.sakila.controller;

import com.film.sakila.request.InsertAddressRequest;
import com.film.sakila.service.AddressService;
import org.locationtech.jts.io.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/address")
public class AddressController {

    @Autowired
    private AddressService addressService;
    @GetMapping("/all")
    public ResponseEntity getAll(){
        return ResponseEntity.ok(addressService.getAll());
    }

    @PostMapping("/insert")
    public ResponseEntity insert(@RequestBody InsertAddressRequest insertAddressRequest) throws ParseException {
        addressService.insert(insertAddressRequest.getAddress(), insertAddressRequest.getDistrict(),
                insertAddressRequest.getCityId(),insertAddressRequest.getPhone(), insertAddressRequest.getLocation());
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
