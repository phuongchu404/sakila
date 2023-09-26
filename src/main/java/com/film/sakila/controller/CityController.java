package com.film.sakila.controller;

import com.film.sakila.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/city")
public class CityController {

    @Autowired
    private CityService cityService;
    @GetMapping("/all")
//    @JsonView(Views.Internal.class)
    public ResponseEntity getAll(@RequestParam int pageNo, @RequestParam int pageSize){
        return ResponseEntity.ok(cityService.getAll(pageNo, pageSize));
    }

}
