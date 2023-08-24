package com.film.sakila.controller;

import com.film.sakila.entity.StaffEntity;
import com.film.sakila.repository.StaffRepository;
import com.film.sakila.service.StaffService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.SQLException;

@RestController
@RequestMapping("/api/admin/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @GetMapping("/all")
    public ResponseEntity getAll(){
        return ResponseEntity.ok(staffService.getAll());
    }

}
