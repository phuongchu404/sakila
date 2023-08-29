package com.film.sakila.service;

import com.film.sakila.data.RevenuePerStore;
import org.springframework.data.domain.Page;

public interface PaymentService {

    Page<RevenuePerStore> getRevenuePerStore(int year, int pageNo, int pageSize);
}
