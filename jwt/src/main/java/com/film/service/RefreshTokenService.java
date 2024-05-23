package com.film.service;

import com.film.entity.RefreshToken;

import java.util.Optional;

public interface RefreshTokenService {

    Optional<RefreshToken> findByToken(String token);

    RefreshToken createRefreshToken(int userId);

    RefreshToken verifyExpiration(RefreshToken token);

    int deleteByUserId(int userId);
}
