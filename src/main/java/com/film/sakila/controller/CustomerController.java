package com.film.sakila.controller;

import com.film.sakila.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

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

    @GetMapping("/top-10-most-revenue")
    public ResponseEntity topTenMostRevenue(){
        return new ResponseEntity(customerService.topTenMostRevenue(), HttpStatus.OK);
    }

    @GetMapping("/rental-by-category")
    public ResponseEntity customerRentalByCategory(@RequestParam(name = "page") int pageNo, @RequestParam(name = "size") int pageSize){
        return new ResponseEntity(customerService.customerRentalByCategory(pageNo, pageSize), HttpStatus.OK);
    }

}
