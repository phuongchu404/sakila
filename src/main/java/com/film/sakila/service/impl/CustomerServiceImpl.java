package com.film.sakila.service.impl;

import com.film.sakila.entity.CustomerEntity;
import com.film.sakila.repository.CustomerRepository;
import com.film.sakila.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<CustomerEntity> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerEntity findById(int id) {
        return customerRepository.findById(id).get();
    }
}
