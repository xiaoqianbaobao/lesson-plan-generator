package com.example.lessonplan.service;

import com.example.lessonplan.entity.User;

public interface UserService {
    User authenticate(String username, String password);
    void register(String username, String password, String email) throws Exception;
    User getUserById(Long id);
    User getUserByUsername(String username);
    User register(User user);
    User findByUsername(String username);
    User findByEmail(String email);
}