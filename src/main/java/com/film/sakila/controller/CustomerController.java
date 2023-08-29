package com.film.sakila.controller;

import com.film.sakila.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/all")
    public ResponseEntity getAll(){
        return ResponseEntity.ok(customerService.getAll());
    }
    @GetMapping("/find/{id}")
    public ResponseEntity findById(@PathVariable(name = "id")int id){
        return ResponseEntity.ok(customerService.findById(id));
    }
    @GetMapping("/find/rental")
    public ResponseEntity getInformationCustomerRented(@RequestParam int year, @RequestParam int month,
                                                       @RequestParam int pageNo, @RequestParam int pageSize){
        return ResponseEntity.ok(customerService.getInformationCustomerRented(year, month, pageNo, pageSize));
    }
}
