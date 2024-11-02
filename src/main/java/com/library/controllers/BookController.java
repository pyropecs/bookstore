package com.library.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.library.models.Book;
import com.library.models.User;
import com.library.repositories.BookRepository;

@Controller
public class BookController {
        @Autowired
        private BookRepository repository;
         @GetMapping("/books")
    public String getMethodName() {
        return "createbook";
    }


@PostMapping("/books/add")
    public ResponseEntity createBook(@ModelAttribute Book book) {
        
        try {
            repository.insertBook(book);
            return new ResponseEntity<>(HttpStatus.CREATED).created(new URI("/alpha")).build();
        } catch (Exception e) {
            System.out.println("something went wrong UserController.createUser()");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
