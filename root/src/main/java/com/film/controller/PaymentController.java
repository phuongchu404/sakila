package com.film.controller;

import com.film.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/revenue/per-store")
    public ResponseEntity getRevenue(@RequestParam int year, @RequestParam int pageNo, @RequestParam int pageSize){
        return new ResponseEntity<>(paymentService.getRevenuePerStore(year, pageNo, pageSize), HttpStatus.OK);
    }

}
