package com.java10x.user_management_api.users.controller;

import com.java10x.user_management_api.users.model.entity.UserModel;
import com.java10x.user_management_api.users.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Add new user (CREATE)
    @PostMapping("/add")
    public UserModel createUser(@RequestBody UserModel user){
        return userService.createUser(user);
    }

    //Show all user(READ)
    @GetMapping("/all")
    public List<UserModel> readAllUsers(){
        return userService.readAllUsers();
    }

    //Show all user by id(READ)
    @GetMapping("/all/{id}")
    public UserModel readAllUserById(@PathVariable Long id){
        return userService.readAllUserById(id);
    }

    //Alter user by id (UPDATE)
    @PutMapping("/alterar/id")
    public String updateUser(){
        return "User updated";
    }

    //Delete user by id (DELETE)
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
    }
}
