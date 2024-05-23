package com.film.controller;

import com.film.service.ActorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/name-actor-particiting-at-least-one-movie")
    public ResponseEntity getNameActorParticitingAtLeastOneMovie(){
        return new ResponseEntity<>(actorService.getNameParticitingAtLeastOneMovie(), HttpStatus.OK);
    }

    @GetMapping("/revenue-by-actor")
    public ResponseEntity getRevenueByActor(){
        return new ResponseEntity(actorService.getRevenueByActor(), HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity getNameActor(@RequestParam String rating, @RequestParam String notRating){
        try {
            List<String> list = actorService.getNameActor(rating, notRating);
            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (IllegalAccessError ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.fillInStackTrace());
        }
    }
}
