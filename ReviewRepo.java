package com.example.FlipkartClone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FlipkartClone.entity.Review;

public interface ReviewRepo extends JpaRepository<Review,Integer>{

}
