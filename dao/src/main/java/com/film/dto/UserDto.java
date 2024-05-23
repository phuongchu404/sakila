package com.film.dto;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link com.film.sakila.entity.User}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
    //@Value
public class UserDto implements Serializable {
    private String userName;
    private String password;
    private String email;
    private String phoneNumber;

}