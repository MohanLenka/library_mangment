package com.example.FlipkartClone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FlipkartClone.entity.Products;

import jakarta.validation.constraints.AssertFalse.List;

public interface ProductRepo extends JpaRepository<Products, Integer>{
    java.util.List<Products> findByDesContains(String des);
}
