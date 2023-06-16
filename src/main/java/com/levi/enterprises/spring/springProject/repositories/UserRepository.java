package com.levi.enterprises.spring.springProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.levi.enterprises.spring.springProject.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
