package com.film.service;

import com.film.data.payment.RevenuePerStore;
import org.springframework.data.domain.Page;

public interface PaymentService {

    Page<RevenuePerStore> getRevenuePerStore(int year, int pageNo, int pageSize);
}
