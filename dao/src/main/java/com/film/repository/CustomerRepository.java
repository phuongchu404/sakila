package com.film.repository;

import com.film.data.customer.CustomerRentalByCategory;
import com.film.data.customer.InformationCustomerRented;
import com.film.data.customer.NameCustomerRentedMovieMultipleTime;
import com.film.data.customer.TopTenMostRevenue;
import com.film.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("select new com.film.data.customer.InformationCustomerRented(c.firstName,c.lastName, a.address, a.district, y.city, t.country, p.paymentDate) " +
            "from Customer c join c.address a " +
            "join a.city y join y.country t join Payment p on p.customer = c " +
            "where year(p.paymentDate)= :year and month(p.paymentDate)= :month")
    Page<InformationCustomerRented> getInformationCustomerRented(@Param("year") int year, @Param("month") int month, Pageable pageable);

    @Query(value = "select new com.film.data.customer.TopTenMostRevenue(c.firstName, c.lastName, sum(p.amount)) from Payment p " +
            "inner join Customer c on p.customer = c " +
            "group by c.id " +
            "order by sum(p.amount) desc limit 10 ")
    List<TopTenMostRevenue> topTenMostRevenue();

    @Query(value = "select new com.film.data.customer.CustomerRentalByCategory(c.firstName, c.lastName, a.address, a.district, ci.city, co.country,c.email, ca.name) from Customer c " +
            "inner join Rental r on r.customer = c " +
            "inner join r.inventory i " +
            "inner join i.film f " +
            "inner join FilmCategory fc on f = fc.film " +
            "inner join fc.category ca " +
            "left join c.address a " +
            "left join a.city ci " +
            "left join ci.country co " +
            "group by c.id, ca.id " +
            "order by ca.id")
    Page<CustomerRentalByCategory> getCustomerRentalByCategory(Pageable pageable);
    @Query(value = "select new com.film.data.customer.NameCustomerRentedMovieMultipleTime(c.firstName, c.lastName,count(*)) from Customer c " +
            "inner join Rental r on r.customer = c " +
            "inner join r.inventory i " +
            "inner join i.film f " +
            "group by c.id, f.id " +
            "having count(*)>1")
    List<NameCustomerRentedMovieMultipleTime> getNameCustomerRentedMovieMultipleTime();

}
