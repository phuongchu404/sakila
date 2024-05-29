package com.film.repository;

import com.film.dto.UserDto;
import com.film.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
    @Query("select u from User u where u.userName = ?1")
    List<UserDto> getUserDto(String userName);

    Optional<User> findByUserName(String userName);

    Boolean existsByUserName(String userName);

    Boolean existsByEmail(String email);

    Optional<User> findByResetPasswordToken(String resetPasswordToken);
    Optional<User> findByEmail(String email);
}