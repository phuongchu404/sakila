package com.film.service.impl;

import com.film.dto.UserDto;
import com.film.entity.User;
import com.film.exception.UserNotFoundException;
import com.film.repository.UserRepository;
import com.film.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public void insertUser(UserDto userDto) {
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPhoneNumber(userDto.getPhoneNumber());
        userRepository.save(user);
    }

    @Override
    public void updateResetPasswordToken(String token, String email) {
        Optional<User> result = userRepository.findByEmail(email);
        if(result.isPresent()) {
            User user =  result.get();
            user.setResetPasswordToken(token);
            userRepository.save(user);
        }else{
            log.error("Could not find user with email " + email);
            throw new RuntimeException("Could not find user with email " + email);
        }
    }

    @Override
    public User getByResetPasswordToken(String token) {
        Optional<User> result = userRepository.findByResetPasswordToken(token);
        if(result.isPresent()) {
            return result.get();
        }
        return null;
    }

    @Override
    public void updatePassword(User user, String newPassword) {
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);
        user.setResetPasswordToken(null);
        userRepository.save(user);
    }
}
