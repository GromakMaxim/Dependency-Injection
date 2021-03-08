package com.example.task05_di.repository;

import com.example.task05_di.model.User;

public interface Repo {
    void save(User user);
    String show();
    void deleteItem(int id);
}
