package com.levi.enterprises.spring.springProject.resources;

import com.levi.enterprises.spring.springProject.entities.Category;
import com.levi.enterprises.spring.springProject.services.CategoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
    
    @Autowired
    private CategoryService catService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> categoryList = catService.findAll();    

        return ResponseEntity.ok().body(categoryList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category category = catService.findById(id);
        return ResponseEntity.ok().body(category);
    }

}
