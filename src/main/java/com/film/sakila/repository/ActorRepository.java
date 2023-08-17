package com.film.sakila.repository;

import com.film.sakila.data.FirstAndLastNameActor;
import com.film.sakila.entity.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<ActorEntity, Integer> {
    @Query(value = "select new com.film.sakila.data.FirstAndLastNameActor(a.firstName, a.lastName) " +
            "from ActorEntity a ")
    public List<FirstAndLastNameActor> getFirstAndLastNameActor();
}
