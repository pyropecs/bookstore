package com.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.models.User;
import com.library.repositories.UserRepository;

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

    @GetMapping("users/all/{id}")
    @ResponseBody
    public List<User> getUsersWithBooks(@PathVariable("id") int bookid){
    List<User> users = repository.getAllUsers(bookid);
    
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
            model.addAttribute("message","internal server error");
            return "alertmessage";
        }
    }

}
