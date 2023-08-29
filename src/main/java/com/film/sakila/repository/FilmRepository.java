package com.film.sakila.repository;

import com.film.sakila.data.AverageRentalByCategory;
import com.film.sakila.data.TopFiveFilm;
import com.film.sakila.entity.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {
    @Query(value = "select new com.film.sakila.data.TopFiveFilm(f.id,f.title,f.description,f.releaseYear,f.language.id," +
            "f.rentalDuration,f.rentalRate,f.length,f.replacementCost,f.rating,f.specialFeatures,f.lastUpdate,count(f)) " +
            "from Film f " +
            "group by f.id " +
            "order by f.rentalDuration desc limit 5")
    List<TopFiveFilm> getTopFiveFilm();
    @Query("select new com.film.sakila.data.AverageRentalByCategory(c.name, avg(f.rentalDuration)) from Film f " +
            "join FilmCategory fc on f.id = fc.film.id " +
            "join Category c on c.id = fc.category.id " +
            "group by c.id")
    List<AverageRentalByCategory> averageRentalByCategory();
}
