package com.java10x.user_management_api.users.dto;

import com.java10x.user_management_api.tasks.model.entity.TaskModel;
import com.java10x.user_management_api.users.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String password;
    private Role role;
    private TaskModel tasks;
}
