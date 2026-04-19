package com.java10x.user_management_api.tasks.service;


import com.java10x.user_management_api.tasks.dto.TaskDTO;
import com.java10x.user_management_api.tasks.mapper.TaskMapper;
import com.java10x.user_management_api.tasks.model.entity.TaskModel;
import com.java10x.user_management_api.tasks.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    public TaskDTO createTask(TaskDTO taskDTO){
        TaskModel novaTask = taskMapper.map(taskDTO);
        novaTask = taskRepository.save(novaTask);

        return taskMapper.map(novaTask);
    }

    public List<TaskDTO> readAllTasks() {
        List<TaskModel> tasks = taskRepository.findAll();

        return tasks.stream()
                .map(taskMapper::map)
                .collect(Collectors.toList());
    }

    public TaskDTO readTaskById(Long id) {
        Optional<TaskModel> task = taskRepository.findById(id);
        return task.map(taskMapper::map).orElse(null);
    }

    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }

    public TaskDTO updateTask(Long id, TaskDTO task) {
        Optional<TaskModel> taskExistente = taskRepository.findById(id);
        if (taskExistente.isPresent()) {
            TaskModel novaTask = taskMapper.map(task);
            novaTask.setId(id);
            TaskModel taskSalva = taskRepository.save(novaTask);

            return taskMapper.map(taskSalva);
        }
        return null;
    }
}
