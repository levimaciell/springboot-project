package com.levi.enterprises.spring.springProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levi.enterprises.spring.springProject.entities.User;
import com.levi.enterprises.spring.springProject.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository uRep;

    public List<User> findAll(){
        return uRep.findAll();
    }

    public User findById(Long id){
        Optional<User> Optional = uRep.findById(id);
        return Optional.get();
    }

}
