package com.film.service.impl;

import com.film.entity.RefreshToken;
import com.film.exception.TokenRefreshException;
import com.film.repository.RefreshTokenRepository;
import com.film.repository.UserRepository;
import com.film.service.RefreshTokenService;
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
    private UserRepository userRepository;

    @Override
    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    @Override
    public RefreshToken createRefreshToken(int userId) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime()+ refreshExpirationMs);
        Optional<RefreshToken> refresh =refreshTokenRepository.findByUserId(userId);
        if(refresh.isPresent()) {
            RefreshToken refreshTokenAdd =refresh.get();
            refreshTokenAdd.setUser(userRepository.findById(userId).get());
            refreshTokenAdd.setExpiryDate(expiryDate);
            refreshTokenAdd.setToken(UUID.randomUUID().toString());
            refreshTokenAdd = refreshTokenRepository.save(refreshTokenAdd);
            return refreshTokenAdd;
        }else{
            RefreshToken refreshToken = new RefreshToken();
            refreshToken.setUser(userRepository.findById(userId).get());
            refreshToken.setExpiryDate(expiryDate);
            refreshToken.setToken(UUID.randomUUID().toString());
            refreshToken = refreshTokenRepository.save(refreshToken);
            return refreshToken;
        }

    }

    @Override
    public RefreshToken verifyExpiration(RefreshToken token) {
        if(token.getExpiryDate().compareTo(new Date()) < 0){
            refreshTokenRepository.delete(token);
            throw new TokenRefreshException(token.getToken(),"Token refresh token was expired");
        }
        return token;
    }

    @Override
    @Transactional
    public int deleteByUserId(int userId) {
        return refreshTokenRepository.deleteByUser(userRepository.findById(userId).get());
    }
}
