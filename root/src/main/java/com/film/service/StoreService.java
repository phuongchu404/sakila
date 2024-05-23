package com.film.service;

import com.film.data.store.RevenueEachStore;
import org.springframework.data.domain.Page;

public interface StoreService {
    Page<RevenueEachStore> getRevenueEachStore(int year, int pageNo, int pageSize);
}
