package com.film.sakila.service.impl;

import com.film.sakila.dto.StaffDto;
import com.film.sakila.entity.Address;
import com.film.sakila.entity.Staff;
import com.film.sakila.entity.Store;
import com.film.sakila.repository.AddressRepository;
import com.film.sakila.repository.StaffRepository;
import com.film.sakila.repository.StoreRepository;
import com.film.sakila.request.StaffCreationRequest;
import com.film.sakila.service.StaffService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public List<StaffDto> getAll() {
        return staffRepository.findAll().stream().map(item ->{
                return new StaffDto(item.getId(), item.getFirstName(), item.getLastName(),
                        item.getAddress().getId(), item.getEmail(), item.getStore().getId(), item.getUserName(), item.getPicture(), item.getLastUpdate());

        }).collect(Collectors.toList());
    }

    @Override
    public StaffDto insert(StaffCreationRequest staffCreationRequest, MultipartFile file) throws IOException {

        byte[] picture = file.getBytes();
        staffCreationRequest.setPicture(picture);
        Staff staff = convertToEntity(staffCreationRequest);
        staffRepository.save(staff);
        return convertToDto(staff);
    }

    private Staff convertToEntity(StaffCreationRequest request){
        Address address = addressRepository.findById(request.getAddressId()).get();
        Store store = storeRepository.findById(request.getStoreId()).get();
        Staff staff = modelMapper.map(request, Staff.class);
        staff.setAddress(address);
        staff.setStore(store);
        return staff;
    }
    private StaffDto convertToDto(Staff staff){
        StaffDto staffDto = modelMapper.map(staff, StaffDto.class);
//        staffDto.setAddressId(staff.getAddress());
//        staffDto.setStoreId(staff.getStore());
        return staffDto;
    }
}
