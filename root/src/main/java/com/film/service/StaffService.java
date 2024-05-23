package com.film.service;

import com.film.dto.StaffDto;
import com.film.request.StaffCreationRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface StaffService {
    List<StaffDto> getAll();
    StaffDto insert(StaffCreationRequest staffCreationRequest, MultipartFile file) throws IOException;
}
