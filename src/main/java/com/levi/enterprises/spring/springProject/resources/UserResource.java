package com.levi.enterprises.spring.springProject.resources;

import com.levi.enterprises.spring.springProject.entities.User;
import com.levi.enterprises.spring.springProject.services.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    
    @Autowired
    private UserService uService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> userList = uService.findAll();    

        return ResponseEntity.ok().body(userList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = uService.findById(id);
        return ResponseEntity.ok().body(user);
    }

}
