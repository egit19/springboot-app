package com.consistech.springboot_app.repository;

import com.consistech.springboot_app.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom method untuk mencari user by username
    User findByUsername(String username);
    
    // Custom method untuk cek username existence
    Boolean existsByUsername(String username);
    
    // Custom method untuk cek email existence
    Boolean existsByEmail(String email);
}