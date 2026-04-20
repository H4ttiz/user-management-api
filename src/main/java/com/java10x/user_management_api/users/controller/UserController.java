package com.java10x.user_management_api.users.controller;

import com.java10x.user_management_api.users.dto.UserDTO;
import com.java10x.user_management_api.users.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Add new user (CREATE)
    @PostMapping("/add")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user){
        UserDTO novoUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUser);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<UserDTO>> readAllUsers(){
        return ResponseEntity.ok(userService.readAllUsers());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> readUserById(@PathVariable Long id){
        UserDTO user = userService.readAllUserById(id);

        if (user != null){
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO user){
        UserDTO existingUser = userService.readAllUserById(id);

        if (existingUser != null){
            return ResponseEntity.ok(userService.updateUser(id, user));
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        UserDTO user = userService.readAllUserById(id);

        if (user != null){
            userService.deleteUserById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
