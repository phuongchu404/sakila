package com.film.sakila.repository;

import com.film.sakila.data.InformationCustomerRented;
import com.film.sakila.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("select new com.film.sakila.data.InformationCustomerRented(c.firstName,c.lastName, a.address, a.district, y.city, t.country, p.paymentDate) " +
            "from Customer c join c.address a " +
            "join a.city y join y.country t join Payment p on p.customer = c " +
            "where year(p.paymentDate)= :year and month(p.paymentDate)= :month")
    Page<InformationCustomerRented> getInformationCustomerRented(@Param("year") int year, @Param("month") int month, Pageable pageable);
}
