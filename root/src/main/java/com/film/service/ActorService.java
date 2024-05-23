package com.film.service;

import com.film.data.actor.ActorParticipatedMoreThanTwentyFilms;
import com.film.data.actor.InformationActor;
import com.film.data.actor.RevenueByActor;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ActorService {

    List<InformationActor> getFirstAndLastNameActor();
    Page<ActorParticipatedMoreThanTwentyFilms> actorParticipatedMoreThanTwentyFilms(int pageNo, int pageSize);
    List<String> getNameParticitingAtLeastOneMovie();

    List<RevenueByActor> getRevenueByActor();

    List<String> getNameActor(String rating, String notRating);
}
