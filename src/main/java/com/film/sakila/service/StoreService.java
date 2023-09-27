package com.film.sakila.service;

import com.film.sakila.data.store.RevenueEachStore;
import org.springframework.data.domain.Page;

public interface StoreService {
    Page<RevenueEachStore> getRevenueEachStore(int year, int pageNo, int pageSize);
}
