package com.film.sakila.repository;

import com.film.sakila.data.actor.ActorParticipatedMoreThanTwentyFilms;
import com.film.sakila.data.actor.InformationActor;
import com.film.sakila.entity.Actor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
    @Query(value = "select new com.film.sakila.data.actor.InformationActor(a.firstName, a.lastName) " +
            "from Actor a ")
    List<InformationActor> getFirstAndLastNameActor();
    @Query(value = "select new com.film.sakila.data.actor.ActorParticipatedMoreThanTwentyFilms(a.firstName,a.lastName, count(f.id.actorId)) from FilmActor f " +
            "left join Actor a on f.actor = a " +
            "group by f.id.actorId " +
            "having count(f.id.actorId)>19")
    Page<ActorParticipatedMoreThanTwentyFilms> actorParticipatedMoreThanTwentyFilms(PageRequest pageRequest);
}
