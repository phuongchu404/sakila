package com.film.sakila.service.impl;

import com.film.sakila.entity.RefreshToken;
import com.film.sakila.exception.TokenRefreshException;
import com.film.sakila.jwt.response.TokenRefreshResponse;
import com.film.sakila.repository.RefreshTokenRepository;
import com.film.sakila.repository.UserRepository;
import com.film.sakila.repository.UserRoleRepository;
import com.film.sakila.service.RefreshTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenServiceImpl implements RefreshTokenService {

    @Value("${app.security.jwtRefreshExpirationMs}")
    private long refreshExpirationMs;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    @Override
    public RefreshToken createRefreshToken(int userId) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime()+ refreshExpirationMs);
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUser(userRepository.findById(userId).get());
        refreshToken.setExpiryDate(expiryDate);
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken = refreshTokenRepository.save(refreshToken);
        return refreshToken;
    }

    @Override
    public RefreshToken verifyExpiration(RefreshToken token) {
        if(token.getExpiryDate().compareTo(new Date()) < 0){
            refreshTokenRepository.delete(token);
            throw new TokenRefreshException(token.getToken(),"Token refresh token was expired");
        }
        return null;
    }

    @Override
    @Transactional
    public int deleteByUserId(int userId) {
        return refreshTokenRepository.deleteByUser(userRepository.findById(userId).get());
    }
}
