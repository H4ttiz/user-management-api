package com.java10x.user_management_api.tasks.mapper;

import com.java10x.user_management_api.tasks.dto.TaskDTO;
import com.java10x.user_management_api.tasks.model.entity.TaskModel;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public TaskModel map(TaskDTO taskDTO) {
        TaskModel taskModel = new TaskModel();

        taskModel.setId(taskDTO.getId());
        taskModel.setName(taskDTO.getName());
        taskModel.setDescription(taskDTO.getDescription());
        taskModel.setDifficulty(taskDTO.getDifficulty());
        taskModel.setUsers(taskDTO.getUsers());

        return taskModel;
    }

    public TaskDTO map(TaskModel taskModel) {
        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setId(taskModel.getId());
        taskDTO.setName(taskModel.getName());
        taskDTO.setDescription(taskModel.getDescription());
        taskDTO.setDifficulty(taskModel.getDifficulty());
        taskDTO.setUsers(taskModel.getUsers());

        return taskDTO;
    }
}
