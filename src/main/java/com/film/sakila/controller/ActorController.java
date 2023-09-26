package com.film.sakila.controller;

import com.film.sakila.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/actor")
public class ActorController {
    private final ActorService actorService;
    public ActorController(ActorService actorService){
        this.actorService = actorService;
    }

    @GetMapping("/all")
    public ResponseEntity getFirstAndLastNameActor(){
        return ResponseEntity.ok(actorService.getFirstAndLastNameActor());
    }

    @GetMapping("/find/more-than-20-films")
    public ResponseEntity actorParticipatedMoreThanTwentyFilms(@RequestParam(name = "page", defaultValue = "0")int pageNo,
                                                               @RequestParam(name = "size", defaultValue = "10")int pageSize){
        return ResponseEntity.ok(actorService.actorParticipatedMoreThanTwentyFilms(pageNo, pageSize));
    }
}
