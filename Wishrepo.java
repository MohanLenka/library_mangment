package com.example.FlipkartClone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FlipkartClone.entity.WishList;

public interface Wishrepo extends JpaRepository<WishList, Integer> {

}
