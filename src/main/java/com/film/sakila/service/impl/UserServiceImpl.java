package com.film.sakila.service.impl;

import com.film.sakila.dto.UserDto;
import com.film.sakila.entity.User;
import com.film.sakila.repository.UserRepository;
import com.film.sakila.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public void insertUser(UserDto userDto) {
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPhoneNumber(userDto.getPhoneNumber());
        userRepository.save(user);
    }
}
