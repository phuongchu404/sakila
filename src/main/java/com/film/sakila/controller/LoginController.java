package com.film.sakila.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final AuthenticationManager authenticationManager;
    public LoginController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    @GetMapping
    String login(){
        return "login";
    }
    @PostMapping
    public ResponseEntity login1(@RequestParam("username") String username, @RequestParam("password") String password){
        Authentication authenticationRequest = UsernamePasswordAuthenticationToken.unauthenticated(username, password);
        Authentication authenticationResponse = this.authenticationManager.authenticate(authenticationRequest);

        return ResponseEntity.ok().build();
    }
    public record LoginRequest(String username, String password){}
}
