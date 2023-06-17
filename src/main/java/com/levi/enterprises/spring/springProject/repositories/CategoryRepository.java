package com.levi.enterprises.spring.springProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.levi.enterprises.spring.springProject.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {   
    
}
