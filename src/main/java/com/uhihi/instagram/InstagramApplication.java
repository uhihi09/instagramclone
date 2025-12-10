package com.uhihi.instagram;

import com.uhihi.instagram.entity.User;
import com.uhihi.instagram.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InstagramApplication {

    public static void main(String[] args) {
        SpringApplication.run(InstagramApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(UserRepository userRepository) {
        return args -> {
            if (userRepository.count() == 0) {
                userRepository.save(User.builder()
                        .username("testuser")
                        .password("1234")
                        .email("test@test.com")
                        .build());

                userRepository.save(User.builder()
                        .username("admin")
                        .password("admin")
                        .email("admin@test.com")
                        .build());

                userRepository.save(User.builder()
                        .username("junha")
                        .password("password123")
                        .email("junha@example.com")
                        .build());

                System.out.println("Hello Instagram!");
            }
        };
    }
}