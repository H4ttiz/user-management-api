package com.java10x.user_management_api.tasks.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {

    // Add new task (CREATE)
    @PostMapping("/add")
    public String createTask(){
        return "Task created";
    }

    //Show all task(READ)
    @GetMapping("/all")
    public String readAllTasks(){
        return "All Task read";
    }

    //Show all task by id(READ)
    @GetMapping("/all/id")
    public String readAllTaskById(){
        return "All Tasks read by id";
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
