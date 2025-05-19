package com.example.demo.service.imp;


import com.example.demo.model.User;
import com.example.demo.service.UserService;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByID(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())) {
            throw new IllegalArgumentException("this user already exists");
        }
        return userRepository.save(userToCreate);
    }

    @Override
    public User UpdateUser(User userToUpdate) {
        if (userToUpdate.getId() != null && userRepository.existsById(userToUpdate.getId())) {
            return userRepository.save(userToUpdate);
        }
        else{
            throw new IllegalArgumentException("this user does not exist");
        }
    }

    @Override
    public User DeleteUser(Long id) {
        var user = userRepository.findById(id).orElseThrow(NoSuchElementException::new);
        userRepository.delete(user);
        return user;
    }

}
