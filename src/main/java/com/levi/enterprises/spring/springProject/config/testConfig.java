package com.levi.enterprises.spring.springProject.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.levi.enterprises.spring.springProject.entities.User;
import com.levi.enterprises.spring.springProject.repositories.UserRepository;

@Configuration
@Profile("test")

public class testConfig implements CommandLineRunner {
    
    @Autowired
    private UserRepository uRep;




    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        uRep.saveAll(Arrays.asList(u1,u2));

        
    }

}
