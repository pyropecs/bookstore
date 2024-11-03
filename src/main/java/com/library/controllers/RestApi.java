package com.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.library.models.User;
import com.library.repositories.UserRepository;


@RestController
public class RestApi{

        @Autowired
        private UserRepository repository;

@GetMapping("users/all/{id}")

public List<User> getUsersWithBooks(@PathVariable("id") int bookid){
List<User> users = repository.getAllUsers(bookid);

return users;



}


}