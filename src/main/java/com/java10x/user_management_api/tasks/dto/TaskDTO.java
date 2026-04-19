package com.java10x.user_management_api.tasks.dto;

import com.java10x.user_management_api.tasks.model.enums.Difficulty;
import com.java10x.user_management_api.users.model.entity.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {

    private Long id;
    private String name;
    private String description;
    private Difficulty difficulty;
    private List<UserModel> users;
}
