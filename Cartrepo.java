package com.example.FlipkartClone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FlipkartClone.entity.CartItem;

public interface Cartrepo extends JpaRepository<CartItem, Integer> {

}
