package com.levi.enterprises.spring.springProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.levi.enterprises.spring.springProject.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
