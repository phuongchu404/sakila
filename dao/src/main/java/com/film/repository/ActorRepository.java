package com.film.repository;


import com.film.data.actor.ActorParticipatedMoreThanTwentyFilms;
import com.film.data.actor.InformationActor;
import com.film.data.actor.RevenueByActor;
import com.film.entity.Actor;
import com.film.status.RatingEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
    @Query(value = "select new com.film.data.actor.InformationActor(a.firstName, a.lastName) " +
            "from Actor a ")
    List<InformationActor> getFirstAndLastNameActor();
    @Query(value = "select new com.film.data.actor.ActorParticipatedMoreThanTwentyFilms(a.firstName,a.lastName, count(f.id.actorId)) from FilmActor f " +
            "left join Actor a on f.actor = a " +
            "group by f.id.actorId " +
            "having count(f.id.actorId)>19")
    Page<ActorParticipatedMoreThanTwentyFilms> actorParticipatedMoreThanTwentyFilms(PageRequest pageRequest);
    @Query(value = "select concat(a.firstName, ' ', a.lastName) from Actor a " +
            "inner join FilmActor fa on fa.actor = a " +
            "inner join Film f on fa.film = f " +
            "inner join FilmCategory fc on fc.film = f " +
            "inner join fc.category " +
            "group by a.id")
    List<String> getNameParticipatingAtLeastOneMovie();
    @Query(value = "select new com.film.data.actor.RevenueByActor(concat(a.firstName, ' ', a.lastName),sum(p.amount)) from Actor a " +
            "inner join FilmActor fa on fa.actor = a " +
            "inner join fa.film f " +
            "inner join Inventory i on i.film = f " +
            "inner join Rental r on r.inventory = i " +
            "inner join Payment p on p.rental = r " +
            "group by a.id")
    List<RevenueByActor> getRevenueByActor();

    @Query(value = "select concat(a.firstName, ' ', a.lastName) from Actor a " +
            "inner join FilmActor fa on fa.actor = a " +
            "inner join fa.film f " +
            "where f.rating = :rating " +
            "and not exists (select f.id from Actor ac " +
                            "inner join FilmActor far on far.actor = ac " +
                            "inner join far.film f " +
                            "where f.rating=:notRating and ac.id = a.id) " +
            "group by a.id")
    List<String> getNameActor(@Param("rating") RatingEnum rating, @Param("notRating")RatingEnum notRating);
}
