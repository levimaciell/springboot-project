package com.levi.enterprises.spring.springProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levi.enterprises.spring.springProject.entities.Order;
import com.levi.enterprises.spring.springProject.repositories.OrderRepository;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository oRep;

    public List<Order> findAll(){
        return oRep.findAll();
    }

    public Order findById(Long id){
        Optional<Order> Optional = oRep.findById(id);
        return Optional.get();
    }

}
