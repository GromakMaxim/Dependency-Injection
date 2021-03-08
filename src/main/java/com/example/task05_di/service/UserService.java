package com.example.task05_di.service;

import com.example.task05_di.model.User;
import com.example.task05_di.repository.UserRepository;

public class UserService {
    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void save(User user) {
        repository.save(user);
    }

    public String show() {
        return repository.show();
    }

    public void deleteItem(int id) {
        repository.deleteItem(id);
    }

    public User getById(int id) {
        return repository.getById(id);
    }
}
