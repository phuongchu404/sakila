package com.film.service;

import com.film.dto.UserDto;
import com.film.entity.User;

public interface UserService {
    void insertUser(UserDto userDto);
    void updateResetPasswordToken(String token, String email);
    User getByResetPasswordToken(String token);
    void updatePassword(User user, String newPassword);
}
