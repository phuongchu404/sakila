package com.film.repository;

import com.film.entity.RefreshToken;
import com.film.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);

    @Query(value = "SELECT r FROM RefreshToken r where r.user.id = ?1")
    Optional<RefreshToken> findByUserId(int userId);

    @Modifying
    int deleteByUser(User user);
}
