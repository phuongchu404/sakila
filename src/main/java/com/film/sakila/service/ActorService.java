package com.film.sakila.service;

import com.film.sakila.data.actor.ActorParticipatedMoreThanTwentyFilms;
import com.film.sakila.data.actor.InformationActor;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ActorService {

    List<InformationActor> getFirstAndLastNameActor();
    Page<ActorParticipatedMoreThanTwentyFilms> actorParticipatedMoreThanTwentyFilms(int pageNo, int pageSize);
}
