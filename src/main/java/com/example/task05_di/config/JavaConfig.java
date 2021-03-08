package com.example.task05_di.config;

import com.example.task05_di.controller.UserController;
import com.example.task05_di.repository.UserRepository;
import com.example.task05_di.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @Bean
    // аргумент метода и есть DI
    // название метода - название бина
    public UserController postController(UserService service) {
        return new UserController(service);
    }

    @Bean
    public UserService postService(UserRepository repository) {
        return new UserService(repository);
    }

    @Bean
    public UserRepository postRepository() {
        return new UserRepository();
    }
}
