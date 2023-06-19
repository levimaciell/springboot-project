package com.levi.enterprises.spring.springProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levi.enterprises.spring.springProject.entities.Product;
import com.levi.enterprises.spring.springProject.repositories.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository prodRep;

    public List<Product> findAll(){
        return prodRep.findAll();
    }

    public Product findById(Long id){
        Optional<Product> Optional = prodRep.findById(id);
        return Optional.get();
    }

}
