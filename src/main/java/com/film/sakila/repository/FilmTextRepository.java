package com.film.sakila.repository;

import com.film.sakila.entity.FilmText;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmTextRepository extends JpaRepository<FilmText, Integer> {
}
