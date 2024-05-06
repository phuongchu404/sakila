package com.film.sakila.service;

import com.film.sakila.entity.RefreshToken;

import java.util.Optional;

public interface RefreshTokenService {

    Optional<RefreshToken> findByToken(String token);

    RefreshToken createRefreshToken(int userId);
    RefreshToken verifyExpiration(RefreshToken token);

    int deleteByUserId(int userId);
}
