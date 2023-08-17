package com.film.sakila.controller;

import com.film.sakila.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/city")
public class CityController {

    @Autowired
    private CityService cityService;
    @GetMapping("/all")
    public ResponseEntity getAll(){
        return ResponseEntity.ok(cityService.getAll());
    }
}
