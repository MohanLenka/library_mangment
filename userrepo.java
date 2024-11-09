package com.example.FlipkartClone.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FlipkartClone.entity.Users;

public interface userrepo extends JpaRepository<Users, Integer> {
      Optional<Users> findByName(String name);
      Optional<Users> findByEmail(String email);
      
}
