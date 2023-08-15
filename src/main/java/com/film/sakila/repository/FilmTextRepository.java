package com.film.sakila.repository;

import com.film.sakila.entity.FilmTextEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmTextRepository extends JpaRepository<FilmTextEntity, Integer> {
}
