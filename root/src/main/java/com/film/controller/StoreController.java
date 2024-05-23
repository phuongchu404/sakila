package com.film.controller;

import com.film.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/store")
public class StoreController {
    private final StoreService storeService;
    @Autowired
    public StoreController(StoreService storeService){
        this.storeService = storeService;
    }
    @GetMapping("/find/revenue-each-store")
    public ResponseEntity getRevenueEachStore(@RequestParam int year, @RequestParam int pageNo,
                                              @RequestParam int pageSize){
        return ResponseEntity.ok(storeService.getRevenueEachStore(year, pageNo, pageSize));
    }
}
