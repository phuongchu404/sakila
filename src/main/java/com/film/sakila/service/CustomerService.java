package com.film.sakila.service;

import com.film.sakila.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAll();

    Customer findById(int id);

}
