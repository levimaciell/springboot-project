package com.levi.enterprises.spring.springProject.resources;

import com.levi.enterprises.spring.springProject.entities.Category;
import com.levi.enterprises.spring.springProject.entities.Product;
import com.levi.enterprises.spring.springProject.services.CategoryService;
import com.levi.enterprises.spring.springProject.services.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
    
    @Autowired
    private ProductService Service;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> List = Service.findAll();    

        return ResponseEntity.ok().body(List);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product product = Service.findById(id);
        return ResponseEntity.ok().body(product);
    }

}
