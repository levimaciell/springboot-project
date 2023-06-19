package com.levi.enterprises.spring.springProject.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.levi.enterprises.spring.springProject.entities.Category;
import com.levi.enterprises.spring.springProject.entities.Order;
import com.levi.enterprises.spring.springProject.entities.Product;
import com.levi.enterprises.spring.springProject.entities.User;
import com.levi.enterprises.spring.springProject.entities.enums.OrderStatus;
import com.levi.enterprises.spring.springProject.repositories.CategoryRepository;
import com.levi.enterprises.spring.springProject.repositories.OrderRepository;
import com.levi.enterprises.spring.springProject.repositories.ProductRepository;
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
    @Autowired
    private ProductRepository prodRep;




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

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        uRep.saveAll(Arrays.asList(u1,u2));
        oRep.saveAll(Arrays.asList(o1,o2,o3));
        catRep.saveAll(Arrays.asList(cat1, cat2, cat3));
        prodRep.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
    }

}
