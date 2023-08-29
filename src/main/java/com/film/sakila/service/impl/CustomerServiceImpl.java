package com.film.sakila.service.impl;

import com.film.sakila.data.InformationCustomerRented;
import com.film.sakila.entity.Customer;
import com.film.sakila.repository.CustomerRepository;
import com.film.sakila.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public Page<InformationCustomerRented> getInformationCustomerRented(int year, int month, int pageNo, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, Sort.by("p.paymentDate").descending());
        Page<InformationCustomerRented> page = customerRepository.getInformationCustomerRented(year, month, pageRequest);
        return page;
    }
}
