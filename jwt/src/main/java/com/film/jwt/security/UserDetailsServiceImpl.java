package com.film.jwt.security;

import com.film.entity.Role;
import com.film.entity.User;
import com.film.repository.UserRepository;
import com.film.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username).orElseThrow(() ->new UsernameNotFoundException("User not found with username: " + username));
        List<Role> roles = userRoleRepository.getRoles(username).orElseThrow(() ->new UsernameNotFoundException("Role not found with username: " + username));
        return UserDetailsImpl.build(user, roles);
    }
}
