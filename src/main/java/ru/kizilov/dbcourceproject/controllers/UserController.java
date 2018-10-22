package ru.kizilov.dbcourceproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kizilov.dbcourceproject.models.Role;
import ru.kizilov.dbcourceproject.models.User;
import ru.kizilov.dbcourceproject.repositories.UserRepo;
import ru.kizilov.dbcourceproject.service.UserService;

import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String userList(Model model){
        model.addAttribute("userList", userService.findAll());
        return "userList";
    }

    @GetMapping("/users/{user}")
    public String userEdit(@PathVariable User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PostMapping("/users/{user}")
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user
    ){

        userService.saveUser(user, username, form);
        return "redirect:/users";
    }




}
