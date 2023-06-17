package com.levi.enterprises.spring.springProject.resources;

import com.levi.enterprises.spring.springProject.entities.Order;
import com.levi.enterprises.spring.springProject.services.OrderService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
    
    @Autowired
    private OrderService oService;

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> orderList = oService.findAll();    

        return ResponseEntity.ok().body(orderList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order order = oService.findById(id);
        return ResponseEntity.ok().body(order);
    }

}
