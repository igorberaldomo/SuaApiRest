package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {

    User findByID(Long id);

    User create(User user);
    
    User UpdateUser(User user);

    User DeleteUser(Long id);
}