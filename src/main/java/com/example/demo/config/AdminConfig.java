package com.example.demo.config;

import com.example.demo.dao.AdminRepository;
import com.example.demo.entity.Admin;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

import java.util.List;

@Configuration
public class AdminConfig {
    @Bean
    CommandLineRunner commandLineRunner(AdminRepository repository) {
        return args -> {
            Admin thu = new Admin(
                    "Thu Pham",
                    "thu1990@gmail.com",
                    "12345678",
                    LocalDate.of(1996, 12, 6),
                    false
            );
            repository.saveAll(
                    List.of(thu)
            );
        };
    }
}
