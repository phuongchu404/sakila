package com.film.sakila.data.actor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActorParticipatedMoreThanTwentyFilms {
    private String fullName; // tên đầy đủ
    private long countParticipating; // số lượt tham gia phim
    public ActorParticipatedMoreThanTwentyFilms(String firstName,String lastName, long countParticipating){
        this.fullName = firstName +" " +lastName;
        this.countParticipating = countParticipating;
    }
}
