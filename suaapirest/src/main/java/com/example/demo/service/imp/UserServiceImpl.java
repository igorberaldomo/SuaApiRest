package main.java.com.example.demo.imp.service;

import main.java.com.example.demo.model.user;
import main.java.com.example.demo.service.UserService;
import main.java.com.example.demo.model.book;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements userService{
    private final UserRepositery userRepositery;

    public UserServiceImplo(UserRepositery userRepositery) {
        this.userRepositery = userRepositery;
    }

    @Override
    public user findByID(int id) {
        return userRepositery.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public user create(user UserToCreate) {
        if (UserToCreate.getId() != null && userRepositery.existsById(UserToCreate.getId())) {
            throw new IllegalArgumentException("this user already exists");
        }
        return userRepositery.save(user);
    }
    
}
