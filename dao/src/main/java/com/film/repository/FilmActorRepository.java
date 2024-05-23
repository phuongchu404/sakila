package com.film.repository;

import com.film.entity.FilmActor;
import com.film.entity.composite.id.FilmActorId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmActorRepository extends JpaRepository<FilmActor, FilmActorId> {
}
