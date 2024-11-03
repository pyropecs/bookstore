package com.library.controllers;

import java.net.URI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;


import com.library.models.User;
import com.library.repositories.UserRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/users")
    public String createUserPage() {
        return "createuser";
    }

    @GetMapping("/users/all")
    public List<User> getAllUsers() {
        List<User> users = repository.getAllUsers();
        return users;

    }



    @PostMapping("/users/add")
    public String createUser(@ModelAttribute User user,Model model) {

        try {
            repository.insertUser(user);
            model.addAttribute("message","successfully user created");
            return "alertmessage";
        } catch (Exception e) {
            System.out.println("something went wrong UserController.createUser()");
            System.out.println(e.getMessage());
            e.printStackTrace();
            model.addAttribute("message","user didn't created");
            return "alertmessage";
        }
    }

}
