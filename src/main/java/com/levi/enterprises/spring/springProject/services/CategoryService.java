package com.levi.enterprises.spring.springProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levi.enterprises.spring.springProject.entities.Category;
import com.levi.enterprises.spring.springProject.repositories.CategoryRepository;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository catRep;

    public List<Category> findAll(){
        return catRep.findAll();
    }

    public Category findById(Long id){
        Optional<Category> Optional = catRep.findById(id);
        return Optional.get();
    }

}
