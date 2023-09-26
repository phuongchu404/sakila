package com.film.sakila.repository;

import com.film.sakila.data.RevenueEachStore;
import com.film.sakila.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {
    @Query(value = "select new com.film.sakila.data.RevenueEachStore(s.id, a.address, a.district, i.city, o.country, sum(p.amount)) from Store s " +
            "inner join Customer c on c.store = s " +
            "inner join Payment p on p.customer = c " +
            "left join s.address a " +
            "left join a.city i " +
            "left join i.country o " +
            "where YEAR(p.paymentDate)=:year " +
            "group by s.id " +
            "order by sum(p.amount)")
    Page<RevenueEachStore> getRevenueEachStore(@Param("year") int year, Pageable pageable);
}
