package main.java.com.example.demo.service;

import main.java.com.example.demo.model.user;
import main.java.com.example.demo.service.imp.UserServiceImpl;
public interface UserService {
    
    User findByID(int id);

    User create(User user);
}