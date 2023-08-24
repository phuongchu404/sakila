package com.film.sakila.repository;

import com.film.sakila.entity.FilmCategory;
import com.film.sakila.entity.composite.id.FilmCategoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmCategoryRepository extends JpaRepository<FilmCategory, FilmCategoryId> {
}
