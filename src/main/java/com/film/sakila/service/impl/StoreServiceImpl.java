package com.film.sakila.service.impl;

import com.film.sakila.data.store.RevenueEachStore;
import com.film.sakila.repository.StoreRepository;
import com.film.sakila.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    @Autowired
    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public Page<RevenueEachStore> getRevenueEachStore(int year,int pageNo, int pageSize){
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
        Page<RevenueEachStore> page = storeRepository.getRevenueEachStore(year, pageRequest);
        return page;
    };
}
