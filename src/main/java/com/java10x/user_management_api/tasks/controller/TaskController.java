package com.java10x.user_management_api.tasks.controller;

import com.java10x.user_management_api.tasks.dto.TaskDTO;
import com.java10x.user_management_api.tasks.model.entity.TaskModel;
import com.java10x.user_management_api.tasks.service.TaskService;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO task){
        TaskDTO novaTask = taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTask);
    }

    //Show all task(READ)
    @GetMapping
    public ResponseEntity<List<TaskDTO>> readAllTasks(){
        return ResponseEntity.ok(taskService.readAllTasks());
    }

    //Show all task by id(READ)
    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> readAllTaskById(@PathVariable Long id){
        TaskDTO user = taskService.readTaskById(id);

        if(user != null){
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

    //Alter task by id (UPDATE)
    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @RequestBody TaskDTO task){
        TaskDTO existingTask = taskService.readTaskById(id);

        if(existingTask != null){
            return ResponseEntity.ok(taskService.updateTask(id,task));
        }
        return ResponseEntity.notFound().build();
    }

    //Delete task by id (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        TaskDTO existingTask = taskService.readTaskById(id);

        if(existingTask != null){
            taskService.deleteTaskById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
