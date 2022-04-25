package com.example.fullstackprojekt.services;

import com.example.fullstackprojekt.models.User;
import com.example.fullstackprojekt.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private User currentUser = null;
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        userRepository.createUser(user);
    }

    public boolean login(String email, String password) {
        User user = userRepository.selectUserByEmail(email);
        if(user == null){
            return false;
        }else if(user.getPassword().equals(password)){
            currentUser = user;
            return true;
        }else{
            return false;
        }
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
