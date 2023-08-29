package com.film.sakila.service;

import com.film.sakila.data.InformationCustomerRented;
import com.film.sakila.entity.Customer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerService {
    List<Customer> getAll();

    Customer findById(int id);

    Page<InformationCustomerRented> getInformationCustomerRented(int year, int month, int pageNo, int pageSize);

}
