package com.java10x.user_management_api.users.service;

import com.java10x.user_management_api.users.dto.UserDTO;
import com.java10x.user_management_api.users.mapper.UserMapper;
import com.java10x.user_management_api.users.model.entity.UserModel;
import com.java10x.user_management_api.users.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDTO createUser(UserDTO userDTO) {
        UserModel user = userMapper.map(userDTO);
        user = userRepository.save(user);
        return userMapper.map(user);
    }

    public List<UserDTO> readAllUsers() {
        List<UserModel> users = userRepository.findAll();
        List<UserDTO> userDTOs = new ArrayList<>();

        for (UserModel user : users) {
            userDTOs.add(userMapper.map(user));
        }

        return userDTOs;
    }

    public UserModel readAllUserById(Long id){
        Optional<UserModel> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public void deleteUserById(Long id){
        userRepository.findById(id);
    }

    public UserModel updateUser(Long id,UserModel user) {
        if(userRepository.existsById(id)){
            user.setId(id);
            return userRepository.save(user);
        }
        return null;
    }
}
