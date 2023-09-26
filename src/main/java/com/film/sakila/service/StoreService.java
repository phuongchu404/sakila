package com.film.sakila.service;

import com.film.sakila.data.RevenueEachStore;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StoreService {
    Page<RevenueEachStore> getRevenueEachStore(int year, int pageNo, int pageSize);
}
