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

    public User insert(User obj){
        return uRep.save(obj);
    }

    public void delete(Long id){
        uRep.deleteById(id);
    }

    public User update(Long id, User obj){

        User entity = uRep.getReferenceById(id);
        updateData(entity, obj);
        return uRep.save(entity);
    }

    private void updateData(User entity, User obj){
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
