package com.film.service;

import com.film.data.customer.CustomerRentalByCategory;
import com.film.data.customer.InformationCustomerRented;
import com.film.data.customer.NameCustomerRentedMovieMultipleTime;
import com.film.data.customer.TopTenMostRevenue;
import com.film.entity.Customer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerService {
    List<Customer> getAll();

    Customer findById(int id);

    Page<InformationCustomerRented> getInformationCustomerRented(int year, int month, int pageNo, int pageSize);

    List<TopTenMostRevenue> topTenMostRevenue();

    Page<CustomerRentalByCategory> customerRentalByCategory(int pageNo, int pageSize);
    List<NameCustomerRentedMovieMultipleTime> getNameCustomerRentedMovieMultipleTime();

}
