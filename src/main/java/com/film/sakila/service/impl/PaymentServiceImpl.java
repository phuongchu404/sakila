package com.film.sakila.service.impl;

import com.film.sakila.data.RevenuePerStore;
import com.film.sakila.repository.PaymentRepository;
import com.film.sakila.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    @Override
    public Page<RevenuePerStore> getRevenuePerStore(int year, int pageNo, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
        List<RevenuePerStore> list = paymentRepository.getRevenuePerStore(year).stream()
                .sorted(Comparator.comparingDouble(RevenuePerStore::getRevenue)).collect(Collectors.toList());
        //convert List to Page
        int start = (int) pageRequest.getOffset();
        int end = Math.min((start+pageRequest.getPageSize()),list.size());
        List<RevenuePerStore> listContent = list.subList(start, end);
        Page<RevenuePerStore> page= new PageImpl<>(listContent, pageRequest, list.size());
        return page;
    }
}
