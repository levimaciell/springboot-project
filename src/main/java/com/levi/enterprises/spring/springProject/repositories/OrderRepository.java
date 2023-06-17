package com.levi.enterprises.spring.springProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.levi.enterprises.spring.springProject.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {   
    
}
