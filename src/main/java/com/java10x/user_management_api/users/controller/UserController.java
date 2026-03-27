package com.java10x.user_management_api.users.controller;

import com.java10x.user_management_api.users.model.entity.UserModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    // Add new user (CREATE)
    @PostMapping("/add")
    public String createUser(){
        return "User created";
    }

    //Show all user(READ)
    @GetMapping("/all")
    public String readAllUsers(){
        return "All Users read";
    }

    //Show all user by id(READ)
    @GetMapping("/all/id")
    public String readAllUserById(){
        return "All Users read by id";
    }

    //Alter user by id (UPDATE)
    @PutMapping("/alterar/id")
    public String updateUser(){
        return "User updated";
    }

    //Delete user by id (DELETE)
    @DeleteMapping("/delete/id")
    public String deleteUser(){
        return "User deleted";
    }
}
