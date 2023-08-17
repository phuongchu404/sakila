package com.film.sakila.repository;

import com.film.sakila.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {
    @Query(value = "select a from AddressEntity a ")
    public List<AddressEntity> getAll();
}
