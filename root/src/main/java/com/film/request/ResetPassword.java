package com.film.request;

import lombok.Data;

@Data
public class ResetPassword {
    private String token;
    private String password;
}
