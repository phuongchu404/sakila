package com.film.sakila.service;

import com.film.sakila.dto.StaffDto;
import com.film.sakila.request.StaffCreationRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface StaffService {
    List<StaffDto> getAll();
    StaffDto insert(StaffCreationRequest staffCreationRequest, MultipartFile file) throws IOException;
}
