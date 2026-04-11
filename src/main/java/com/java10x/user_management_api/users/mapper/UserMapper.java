package com.java10x.user_management_api.users.mapper;

import com.java10x.user_management_api.users.dto.UserDTO;
import com.java10x.user_management_api.users.model.entity.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserModel map(UserDTO userDTO) {

        UserModel userModel = new UserModel();
        userModel.setId(userDTO.getId());
        userModel.setName(userDTO.getName());
        userModel.setEmail(userDTO.getEmail());
        userModel.setPassword(userDTO.getPassword());
        userModel.setRole(userDTO.getRole());
        userModel.setTasks(userDTO.getTasks());

        return userModel;
    }

    public UserDTO map(UserModel userModel) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userModel.getId());
        userDTO.setName(userModel.getName());
        userDTO.setEmail(userModel.getEmail());
        userDTO.setPassword(userModel.getPassword());
        userDTO.setRole(userModel.getRole());
        userDTO.setTasks(userModel.getTasks());

        return userDTO;
    }
}
