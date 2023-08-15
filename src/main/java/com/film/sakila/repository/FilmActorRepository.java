package com.film.sakila.repository;

import com.film.sakila.entity.FilmActorEntity;
import com.film.sakila.entity.compositeId.FilmActorId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmActorRepository extends JpaRepository<FilmActorEntity, FilmActorId> {
}
