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

    public UserModel createUser(UserModel user) {
        return userRepository.save(user);
    }

    public List<UserModel> readAllUsers(){
        return userRepository.findAll();
    }

    public UserModel readAllUserById(Long id){
        Optional<UserModel> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public void deleteUserById(Long id){
        userRepository.findById(id);
    }
}
