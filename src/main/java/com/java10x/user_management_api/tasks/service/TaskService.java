package com.java10x.user_management_api.tasks.service;


import com.java10x.user_management_api.tasks.model.entity.TaskModel;
import com.java10x.user_management_api.tasks.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskModel createTask(TaskModel task){
        return taskRepository.save(task);
    }

    public List<TaskModel> readAllTasks() {
        return taskRepository.findAll();
    }

    public TaskModel readTaskById(Long id) {
        Optional<TaskModel> task = taskRepository.findById(id);
        return task.orElse(null);
    }

    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }

    public TaskModel updateTask(Long id, TaskModel task) {
        if(taskRepository.existsById(id)){
            task.setId(id);
            return taskRepository.save(task);
        }
        return null;
    }
}
