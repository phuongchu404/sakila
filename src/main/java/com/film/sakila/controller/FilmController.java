package com.film.sakila.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.film.sakila.common.Views;
import com.film.sakila.request.InsertFilmRequest;
import com.film.sakila.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/film")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping("/title")
    @JsonView(Views.FilmTitleRateCost.class)
    public ResponseEntity getTitle(){
        return new ResponseEntity<>(filmService.getTitleRateCost(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity insert(@RequestBody InsertFilmRequest insertFilmRequest){
        filmService.insert(insertFilmRequest.getTitle(), insertFilmRequest.getLanguageId(), insertFilmRequest.getRating(), insertFilmRequest.getSpecialFeature());
        return ResponseEntity.ok(HttpStatus.OK);
    }

//    @GetMapping("/all")
//    public ResponseEntity getAll(){
//        return new ResponseEntity<>(filmService.getAll(),HttpStatus.OK);
//    }

    @GetMapping("/top/5")
    public ResponseEntity getTopFiveFilm(){
        return ResponseEntity.ok(filmService.getTopFiveFilm());
    }
}
