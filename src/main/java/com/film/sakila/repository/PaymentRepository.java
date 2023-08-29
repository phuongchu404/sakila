package com.film.sakila.repository;

import com.film.sakila.data.RevenuePerStore;
import com.film.sakila.entity.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    @Query("select new com.film.sakila.data.RevenuePerStore(a.address, a.district,c.city, y.country, s.firstName, s.lastName, s.picture, sum(p.amount)) " +
            "from Payment p join p.staff s join s.store t join t.address a join a.city c join c.country y " +
            "where year(p.paymentDate)=:year " +
            "group by t.id ")
    List<RevenuePerStore> getRevenuePerStore(@Param("year") int year);
}
