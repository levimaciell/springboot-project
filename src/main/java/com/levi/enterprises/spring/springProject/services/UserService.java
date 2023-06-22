package com.levi.enterprises.spring.springProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.levi.enterprises.spring.springProject.entities.User;
import com.levi.enterprises.spring.springProject.repositories.UserRepository;
import com.levi.enterprises.spring.springProject.services.exceptions.DatabaseException;
import com.levi.enterprises.spring.springProject.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
    
    @Autowired
    private UserRepository uRep;

    public List<User> findAll(){
        return uRep.findAll();
    }

    public User findById(Long id){
        Optional<User> Optional = uRep.findById(id);
        return Optional.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj){
        return uRep.save(obj);
    }

    public void delete(Long id){

        try{
            if(uRep.existsById(id)){
                uRep.deleteById(id);
            }
            else{
                throw new ResourceNotFoundException(id);
            }
        }
        catch(DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
        
    }

    public User update(Long id, User obj){

        try{
            User entity = uRep.getReferenceById(id);
            updateData(entity, obj);
            return uRep.save(entity);
        }
        catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
        
    }

    private void updateData(User entity, User obj){
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
