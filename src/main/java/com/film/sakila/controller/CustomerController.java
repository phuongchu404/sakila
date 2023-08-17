package com.film.sakila.controller;

import com.film.sakila.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
