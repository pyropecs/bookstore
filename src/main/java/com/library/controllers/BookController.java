package com.library.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.library.models.Book;
import com.library.repositories.BookRepository;

@Controller
public class BookController {
        @Autowired
        private BookRepository repository;
         @GetMapping("/books")
    public String getCreateBookPage() {
        return "createbook";
    }



    @PostMapping("/books/add")
    public String createBook(@ModelAttribute Book book,Model model) {
        
        try {
            repository.insertBook(book);
            model.addAttribute("message","book successfully created");
            return "alertmessage";
        } catch (Exception e) {
            System.out.println("something went wrong UserController.createUser()");
            System.out.println(e.getMessage());
            e.printStackTrace();
            model.addAttribute("message", "book successfully created");
            return "alertmessage";
        }
    }
 
    

}
