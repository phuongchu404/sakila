package com.film.sakila.controller;

import com.film.sakila.entity.Role;
import com.film.sakila.entity.User;
import com.film.sakila.entity.UserRole;
import com.film.sakila.jwt.JwtUtils;
import com.film.sakila.jwt.response.MessageResponse;
import com.film.sakila.repository.RoleRepository;
import com.film.sakila.repository.UserRepository;
import com.film.sakila.repository.UserRoleRepository;
import com.film.sakila.request.LoginRequest;
import com.film.sakila.jwt.response.JwtResponse;
import com.film.sakila.jwt.security.UserDetailsImpl;
import com.film.sakila.request.RegisterRequest;
import com.film.sakila.status.ERole;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
@Slf4j
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities()
                                        .stream().map(item -> item.getAuthority())
                                        .collect(Collectors.toList());
        return null;
        //return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles ));
    }
    @PostMapping("/signup")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest registerRequest){
        // check username and email
        if(userRepository.existsByUserName(registerRequest.getUserName())){
            log.error("Error: Username is already taken!");
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }
        if(userRepository.existsByEmail(registerRequest.getEmail())){
            log.error("Error: Email is already in use!");
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }

        User user = new User();
        user.setUserName(registerRequest.getUserName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        userRepository.save(user);
        Set<String> strRoles = registerRequest.getRoles();
        Set<UserRole> userRoles = new HashSet<>();
        if(strRoles == null){
            Role role = roleRepository.findByRoleName(ERole.USER.getValue()).orElseThrow(()->new RuntimeException("Role is not found"));
            UserRole userRole  = new UserRole();
            userRole.setRole(role);
            userRole.setUser(user);
            userRoles.add(userRole);
        }else{
            strRoles.forEach(role ->{
                switch (role){
                    case "ADMIN":{
                        Role roleAdmin = roleRepository.findByRoleName(ERole.ADMIN.getValue()).orElseThrow(()-> new RuntimeException("Role admin not found"));
                        UserRole userRole  = new UserRole();
                        userRole.setUser(user);
                        userRole.setRole(roleAdmin);
                        userRoles.add(userRole);
                        break;
                    }
                    case "USER":{
                        Role roleUser = roleRepository.findByRoleName(ERole.USER.getValue()).orElseThrow(()-> new RuntimeException("Role admin not found"));
                        UserRole userRole  = new UserRole();
                        userRole.setUser(user);
                        userRole.setRole(roleUser);
                        userRoles.add(userRole);
                        break;
                    }
                    case "MANAGER":{
                        Role roleManager = roleRepository.findByRoleName(ERole.MANAGER.getValue()).orElseThrow(()-> new RuntimeException("Role admin not found"));
                        UserRole userRole  = new UserRole();
                        userRole.setUser(user);
                        userRole.setRole(roleManager);
                        userRoles.add(userRole);
                        break;
                    }
                    default:
                        Role roleDefault = roleRepository.findByRoleName(ERole.USER.getValue()).orElseThrow(()->new RuntimeException("Role is not found"));
                        UserRole userRole  = new UserRole();
                        userRole.setUser(user);
                        userRole.setRole(roleDefault);
                        userRoles.add(userRole);
                        break;
                }
            });
        }
        userRoleRepository.saveAll(userRoles);
        return  ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
//    public record LoginRequest(String username, String password){}
}
