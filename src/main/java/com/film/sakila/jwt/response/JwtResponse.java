package com.film.sakila.jwt.response;

import lombok.Data;

import java.util.List;
@Data
public class JwtResponse {
    private String token;
    //private String type = "Bearer";
    private Integer id;
    private String userName;
    private String email;
    private List<String> roles;

    //refresh token
    private String refreshToken;

    public JwtResponse(String token,String refreshToken, Integer id, String userName, String email, List<String> roles) {
        this.token = token;
        this.refreshToken = refreshToken;
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.roles = roles;
    }
}
