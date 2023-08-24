package com.film.sakila.service.impl;

import com.film.sakila.dto.StaffDto;
import com.film.sakila.entity.StaffEntity;
import com.film.sakila.repository.StaffRepository;
import com.film.sakila.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffRepository staffRepository;

    @Override
    public List<StaffDto> getAll() {
        return staffRepository.findAll().stream().map(item ->{
                return new StaffDto(item.getId(), item.getFirstName(), item.getLastName(),
                        item.getAddress().getId(), item.getEmail(), item.getStore().getId(), item.getUserName(), item.getPicture(), item.getLastUpdate());

        }).collect(Collectors.toList());
    }
}
