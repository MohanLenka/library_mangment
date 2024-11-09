package com.example.FlipkartClone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FlipkartClone.entity.Categories;

public interface Categoriesrepo extends JpaRepository<Categories, Integer> {

}
