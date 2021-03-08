package com.example.task05_di.repository;

import com.example.task05_di.model.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class UserRepository implements Repo {
    private Map<Integer, User> repository = new ConcurrentHashMap<>();
    private AtomicInteger repIndex = new AtomicInteger(0);


    public void save(User user) {
        repository.put(repIndex.incrementAndGet(), user);
    }

    public String show() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, User> entry : repository.entrySet()) {
            sb.append(entry.getKey() + ": " + entry.getValue().toString() + "\n");
        }
        return sb.toString();
    }

    public void deleteItem(int id) {
        repository.remove(id);
    }

    public User getById(int id) {
        return repository.get(id);
    }
}
