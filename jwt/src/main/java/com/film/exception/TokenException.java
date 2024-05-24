package com.film.exception;

public class TokenException extends RuntimeException {
    public TokenException(String token, String message){
        super(String.format("Token [%s] in redis: %s", token, message));
    }

}
