package com.example.PP31.Boot.controller;

import com.example.PP31.Boot.model.User;
import com.example.PP31.Boot.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;


@Controller
@RequestMapping(value = "")
public class UserController {

    private final Service service;

    @Autowired
    public UserController(Service service) {
        this.service = service;
    }

    @GetMapping("")
    public String getAllUsers(Model model) {
        List<User> users = service.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    //create
    @GetMapping("/create_user")
    public String getCreateUser(Model model) {
        model.addAttribute("user", new User());
        return "create_user";
    }

    @PostMapping("/create_user")
    public String getAddUser(@ModelAttribute("user") User user) {
        service.addUser(user);
        return "redirect:/";
    }

    //upd
    @GetMapping("/update_user")
    public String getWhatUpdateUser(Model model) {
        model.addAttribute("userUpdate", new User());
        return "update_user";
    }

    @PostMapping("/update_user")
    public String getUpdateUser(@ModelAttribute("userUpdate") User user) {
        try {
            service.updateUser(user.getId(), user);
        } catch (Exception e) {
            System.out.println("No this user!");
        }
        return "redirect:/";
    }

    //delete
    @GetMapping("/delete_user")
    public String getWhatDeleteUser(Model model) {
        model.addAttribute("userDelete", new User());
        return "delete_user";
    }

    @PostMapping("/delete_user")
    public String getDeleteUser(@ModelAttribute("userDelete") User user) {
        try {
            service.deleteUser(user.getId());
        } catch (Exception e) {
            System.out.println("Error");
        }

        return "redirect:/";
    }

}
