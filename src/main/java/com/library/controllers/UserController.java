package com.library.controllers;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.library.models.User;
import com.library.repositories.UserRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/users")
    public String getMethodName() {
        return "createuser";
    }

    @PostMapping("/users/add")
    public ResponseEntity createUser(@ModelAttribute User user) {
        
        try {
            repository.insertUser(user);
            return new ResponseEntity<>(HttpStatus.CREATED).created(new URI("/alpha")).build();
        } catch (Exception e) {
            System.out.println("something went wrong UserController.createUser()");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
