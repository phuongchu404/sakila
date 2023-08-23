package com.film.sakila.repository;

import com.film.sakila.entity.FilmCategoryEntity;
import com.film.sakila.entity.composite.id.FilmCategoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmCategoryRepository extends JpaRepository<FilmCategoryEntity, FilmCategoryId> {
}
