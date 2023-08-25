package com.film.sakila.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.film.sakila.common.Views;
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
    @JsonView(Views.Internal.class)
    public ResponseEntity getAll(){
        return ResponseEntity.ok(cityService.getAll());
    }
}
