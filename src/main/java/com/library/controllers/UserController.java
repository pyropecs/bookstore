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

import com.library.models.Book;
import com.library.models.User;
import com.library.repositories.BookRepository;
import com.library.repositories.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/users")
    public String createUserPage() {
        return "createuser";
    }

    @GetMapping("/users/all")
    public List<User> getAllUsers() {
        List<User> users = null;
        try {
            users = userRepository.getAllUsers();
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage() + " UserController.getAllUsers()");
            e.printStackTrace();
        }

        return users;

    }

    @GetMapping("users/all/{id}")
    @ResponseBody
    public List<User> getUsersWithBooks(@PathVariable("id") int bookid) {
        List<User> users = null;
        try {
            users = userRepository.getAllUsers(bookid);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage() + " UserController.getUsersWithBooks()");
            e.printStackTrace();

        }

        return users;
    }

    @PostMapping("/users/add")
    public String createUser(@ModelAttribute User user, Model model) {

        try {
            userRepository.insertUser(user);
            model.addAttribute("message", "User Created Successfully");
            return "redirect:/users";
        } catch (Exception e) {
            System.out.println("something went wrong UserController.createUser()");
            System.out.println(e.getMessage());
            e.printStackTrace();
            model.addAttribute("message", "Internal Server Error");
            return "redirect:/users";
        }
    }

    @GetMapping("/addusers")
    public String getAddUserToPage(Model model) {

        List<Book> books = bookRepository.getAllBooks();
        List<User> users = userRepository.getAllUsers();
        model.addAttribute("books", books);
        model.addAttribute("users", users);
        return "addusertobook";
    }

}
