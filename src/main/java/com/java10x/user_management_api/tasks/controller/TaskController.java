package com.java10x.user_management_api.tasks.controller;

import com.java10x.user_management_api.tasks.dto.TaskDTO;
import com.java10x.user_management_api.tasks.model.entity.TaskModel;
import com.java10x.user_management_api.tasks.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Add new task (CREATE)
    @PostMapping("/add")
    public TaskDTO createTask(@RequestBody TaskDTO task){
        return taskService.createTask(task);
    }

    //Show all task(READ)
    @GetMapping("/all")
    public List<TaskDTO> readAllTasks(){
        return taskService.readAllTasks();
    }

    //Show all task by id(READ)
    @GetMapping("/all/{id}")
    public TaskDTO readAllTaskById(@PathVariable Long id){
        return taskService.readTaskById(id);
    }

    //Alter task by id (UPDATE)
    @PutMapping("/alterar/{id}")
    public TaskDTO updateTask(@PathVariable Long id, @RequestBody TaskDTO task){
        return taskService.updateTask(id, task);
    }

    //Delete task by id (DELETE)
    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTaskById(id);
    }
}
