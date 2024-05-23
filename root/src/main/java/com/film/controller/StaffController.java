package com.film.controller;

import com.film.request.StaffCreationRequest;
import com.film.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/admin/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @GetMapping("/all")
    public ResponseEntity getAll(){
        return ResponseEntity.ok(staffService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity insert(@RequestPart("data") StaffCreationRequest staffCreationRequest, @RequestPart("file")MultipartFile file) throws IOException {
        return ResponseEntity.ok(staffService.insert(staffCreationRequest, file));
    }

}
