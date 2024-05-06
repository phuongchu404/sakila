package com.film.sakila.controller;

import com.film.sakila.dto.UserDto;
import com.film.sakila.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/insert")
    public ResponseEntity insert(@RequestBody UserDto userDto) {
        userService.insertUser(userDto);
        return ResponseEntity.ok().build();
    }

}
