package com.java10x.user_management_api.users.service;

import com.java10x.user_management_api.users.model.entity.UserModel;
import com.java10x.user_management_api.users.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Add new user
    public UserModel createUser(UserModel user) {
        return userRepository.save(user);
    }

    // Show all user
    public List<UserModel> readAllUsers(){
        return userRepository.findAll();
    }

    //Show all task by id
    public UserModel readAllUserById(Long id){
        Optional<UserModel> user = userRepository.findById(id);
        return user.orElse(null);
    }
}
