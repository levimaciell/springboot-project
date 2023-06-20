package com.levi.enterprises.spring.springProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.levi.enterprises.spring.springProject.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {   
    
}
