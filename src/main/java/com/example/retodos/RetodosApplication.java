package com.example.retodos;

import com.example.retodos.Crud.CosmeticCrudRepository;
import com.example.retodos.Crud.OrderCrudRepository;
import com.example.retodos.Crud.UserCrudRepository;
import com.example.retodos.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.servlet.ServletOutputStream;
import java.util.List;

@SpringBootApplication
public class RetodosApplication implements CommandLineRunner {
    @Autowired
    private OrderCrudRepository orderCrudRepository;
    @Autowired
    private UserCrudRepository userCrudRepository;
    @Autowired
    private CosmeticCrudRepository cosmeticCrudRepository;

    public static void main(String[] args) {
        SpringApplication.run(RetodosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        cosmeticCrudRepository.deleteAll();
        userCrudRepository.deleteAll();
        orderCrudRepository.deleteAll();
    }

}