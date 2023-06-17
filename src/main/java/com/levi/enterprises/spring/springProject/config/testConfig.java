package com.levi.enterprises.spring.springProject.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.levi.enterprises.spring.springProject.entities.Category;
import com.levi.enterprises.spring.springProject.entities.Order;
import com.levi.enterprises.spring.springProject.entities.User;
import com.levi.enterprises.spring.springProject.entities.enums.OrderStatus;
import com.levi.enterprises.spring.springProject.repositories.CategoryRepository;
import com.levi.enterprises.spring.springProject.repositories.OrderRepository;
import com.levi.enterprises.spring.springProject.repositories.UserRepository;

@Configuration
@Profile("test")

public class testConfig implements CommandLineRunner {
    
    @Autowired
    private UserRepository uRep;
    @Autowired
    private OrderRepository oRep;
    @Autowired
    private CategoryRepository catRep;




    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.PAID);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2,OrderStatus.SHIPPED);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.DELIVERED);
        
        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        uRep.saveAll(Arrays.asList(u1,u2));
        oRep.saveAll(Arrays.asList(o1,o2,o3));
        catRep.saveAll(Arrays.asList(cat1, cat2, cat3));
    }

}
