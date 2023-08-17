package com.film.sakila.controller;

import com.film.sakila.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/address")
public class AddressController {

    @Autowired
    private AddressService addressService;
    @GetMapping("/all")
    public ResponseEntity getAll(){
        return ResponseEntity.ok(addressService.getAll());
    }
}
