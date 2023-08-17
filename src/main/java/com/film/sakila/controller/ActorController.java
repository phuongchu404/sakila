package com.film.sakila.controller;

import com.film.sakila.data.FirstAndLastNameActor;
import com.film.sakila.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/actor")
public class ActorController {
    @Autowired
    private ActorService actorService;

    @GetMapping("/all")
    public ResponseEntity getFirstAndLastNameActor(){
        return ResponseEntity.ok(actorService.getFirstAndLastNameActor());
    }
}
