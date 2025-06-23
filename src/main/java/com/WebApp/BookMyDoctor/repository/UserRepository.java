package com.WebApp.BookMyDoctor.repository;

import com.WebApp.BookMyDoctor.Entity.User;
import com.WebApp.BookMyDoctor.Entity.enums;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {
    List<User> findByRole(enums.Role role);
    @Query("SELECT u FROM User u WHERE " +
            "LOWER(u.location) LIKE LOWER(CONCAT(:input, '%')) OR " +
            "LOWER(u.specialization) LIKE LOWER(CONCAT(:input, '%')) OR " +
            "LOWER(u.location) LIKE LOWER(CONCAT('% ', :input, '%')) OR " +
            "LOWER(u.specialization) LIKE LOWER(CONCAT('% ', :input, '%'))")
    List<User> findByLocationOrSpecialization(@Param("input") String input);
    Optional<User> findByEmailAndPasswordAndRole(String email, String password, enums.Role role);
    Optional<User> findByEmail(String email);
}
