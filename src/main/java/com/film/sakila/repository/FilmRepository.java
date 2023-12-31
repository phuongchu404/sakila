package com.film.sakila.repository;

import com.film.sakila.data.film.AverageRentalByCategory;
import com.film.sakila.data.film.TopFiveFilm;
import com.film.sakila.entity.Film;
import com.film.sakila.status.RatingEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {
    //trả về 5 bộ phim được thuê nhiều nhất trong csdl
    @Query(value = "select new com.film.sakila.data.film.TopFiveFilm(f.id,f.title,f.description,f.releaseYear,f.language.id," +
            "f.rentalDuration,f.rentalRate,f.length,f.replacementCost,f.rating,f.specialFeatures,f.lastUpdate,count(f)) " +
            "from Film f " +
            "group by f.id " +
            "order by f.rentalDuration desc limit 5")
    List<TopFiveFilm> getTopFiveFilm();
    //thời lượng thuê trung bình cho từng danh mục phim trong csdl
    @Query("select new com.film.sakila.data.film.AverageRentalByCategory(c.name, avg(f.rentalDuration)) from Film f " +
            "join FilmCategory fc on f.id = fc.film.id " +
            "join Category c on c.id = fc.category.id " +
            "group by c.id")
    List<AverageRentalByCategory> averageRentalByCategory();
    @Query(value = "select f.title from Film f " +
            "where f.length > :length and f.rating=:rating ")
    List<String> getTitleFilm(@Param("length")int length, @Param("rating") RatingEnum rating);
    @Query(value = "select f.title from Film f " +
            "inner join Inventory i on i.film = f " +
            "inner join Rental r on r.inventory = i " +
            "where r.returnDate is null " +
            "and exists (select fi.id from Rental ren " +
                        "inner join ren.inventory inven " +
                        "inner join inven.film fi " +
                        "where f.id = fi.id and ren.returnDate is not null) " +
            "group by f.id " +
            "order by f.id")
    List<String> getTitleNotReturnDate();
}
