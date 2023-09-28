package com.film.sakila.service;

import com.film.sakila.data.actor.ActorParticipatedMoreThanTwentyFilms;
import com.film.sakila.data.actor.InformationActor;
import com.film.sakila.data.actor.RevenueByActor;
import com.film.sakila.status.RatingEnum;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ActorService {

    List<InformationActor> getFirstAndLastNameActor();
    Page<ActorParticipatedMoreThanTwentyFilms> actorParticipatedMoreThanTwentyFilms(int pageNo, int pageSize);
    List<String> getNameParticitingAtLeastOneMovie();

    List<RevenueByActor> getRevenueByActor();

    List<String> getNameActor(String rating, String notRating);
}
