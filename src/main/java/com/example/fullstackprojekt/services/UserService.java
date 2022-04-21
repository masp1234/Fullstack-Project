package com.example.fullstackprojekt.services;

import com.example.fullstackprojekt.models.User;
import com.example.fullstackprojekt.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        userRepository.createUser(user);
    }
}
