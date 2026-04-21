package com.java10x.user_management_api.users.service;

import com.java10x.user_management_api.users.dto.UserDTO;
import com.java10x.user_management_api.users.mapper.UserMapper;
import com.java10x.user_management_api.users.model.entity.UserModel;
import com.java10x.user_management_api.users.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

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
        return users.stream()
                .map(userMapper::map)
                .collect(Collectors.toList());
    }

    public UserDTO readAllUserById(Long id){
        Optional<UserModel> user = userRepository.findById(id);
        return user.map(userMapper::map).orElse(null);
    }

    public void deleteUserById(Long id){
        userRepository.findById(id);
    }

    public UserDTO updateUser(Long id,UserDTO user) {
        Optional<UserModel> userExistente = userRepository.findById(id);
        if(userExistente.isPresent()){
            UserModel userAtualizado = userMapper.map(user);
            userAtualizado.setId(id);
            UserModel ninjaSalvo = userRepository.save(userAtualizado);
            return userMapper.map(ninjaSalvo);
        }
        return null;
    }
}
