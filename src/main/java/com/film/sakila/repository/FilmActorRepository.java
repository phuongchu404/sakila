package com.film.sakila.repository;

import com.film.sakila.entity.FilmActor;
import com.film.sakila.entity.composite.id.FilmActorId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmActorRepository extends JpaRepository<FilmActor, FilmActorId> {
}
