package com.java10x.user_management_api.users.ui;

import com.java10x.user_management_api.users.dto.UserDTO;
import com.java10x.user_management_api.users.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user/ui")
public class UserControllerUi {

    private final UserService userService;

    public UserControllerUi(UserService userService) {
        this.userService = userService;
    }

    // LISTAR
    @GetMapping
    public String readAllUsers(Model model) {
        model.addAttribute("users", userService.readAllUsers());
        return "listarUsers";
    }

    // FORM CREATE
    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "formUser";
    }

    // SALVAR
    @PostMapping("/save")
    public String saveUser(@ModelAttribute UserDTO user) {
        userService.createUser(user);
        return "redirect:/user/ui";
    }

    // FORM EDIT
    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.readAllUserById(id));
        return "formUser";
    }

    // DELETE
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/user/ui";
    }
}
