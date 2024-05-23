package com.film.service.impl;

import com.film.data.customer.CustomerRentalByCategory;
import com.film.data.customer.InformationCustomerRented;
import com.film.data.customer.NameCustomerRentedMovieMultipleTime;
import com.film.data.customer.TopTenMostRevenue;
import com.film.entity.Customer;
import com.film.repository.CustomerRepository;
import com.film.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository =  customerRepository;
    }
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

    @Override
    public List<TopTenMostRevenue> topTenMostRevenue() {
        List<TopTenMostRevenue> list = customerRepository.topTenMostRevenue();
        return list;
    }

    @Override
    public Page<CustomerRentalByCategory> customerRentalByCategory(int pageNo, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
        Page<CustomerRentalByCategory> page = customerRepository.getCustomerRentalByCategory(pageRequest);
        return page;
    }

    @Override
    public List<NameCustomerRentedMovieMultipleTime> getNameCustomerRentedMovieMultipleTime() {
        List<NameCustomerRentedMovieMultipleTime> list = customerRepository.getNameCustomerRentedMovieMultipleTime();
        return list;
    }
}
