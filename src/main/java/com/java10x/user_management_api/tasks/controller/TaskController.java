package com.java10x.user_management_api.tasks.controller;

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
    public TaskModel createTask(@RequestBody TaskModel task){
        return taskService.createTask(task);
    }

    //Show all task(READ)
    @GetMapping("/all")
    public List<TaskModel> readAllTasks(){
        return taskService.readAllTasks();
    }

    //Show all task by id(READ)
    @GetMapping("/all/{id}")
    public TaskModel readAllTaskById(@PathVariable Long id){
        return taskService.readTaskById(id);
    }

    //Alter task by id (UPDATE)
    @PutMapping("/alterar/id")
    public String updateTask(){
        return "Task updated";
    }

    //Delete task by id (DELETE)
    @DeleteMapping("/delete/id")
    public String deleteTask(){
        return "Task deleted";
    }
}
