package com.film.sakila.service;

import com.film.sakila.entity.CustomerEntity;

import java.util.List;

public interface CustomerService {
    List<CustomerEntity> getAll();

    CustomerEntity findById(int id);

}
