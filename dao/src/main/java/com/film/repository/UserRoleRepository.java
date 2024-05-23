package com.film.repository;

import com.film.entity.Role;
import com.film.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer>, JpaSpecificationExecutor<UserRole> {
    @Query("select u from UserRole u where u.user.userName = ?1")
    Optional<UserRole> findByUserName(String userName);

    @Query("select u.role from UserRole u inner join u.user user where user.userName = ?1")
    Optional<List<Role>> getRoles(String userName);

    @Query(value = "select u from UserRole u join u.role r where r.id = ?1")
    Optional<UserRole> findByRoleId(Integer roleId);

}