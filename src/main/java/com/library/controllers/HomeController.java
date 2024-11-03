package com.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.library.models.Book;
import com.library.models.User;
import com.library.repositories.BookRepository;
import com.library.repositories.UserRepository;

@Controller
public class HomeController {

@Autowired        
private BookRepository repository;

@Autowired
private UserRepository userRepository;
    @GetMapping("/")
    public String renderHomePage(){
        System.out.println("rendering");
        return "home";
    }

@GetMapping("/view")
public String viewBooks(Model model){
List<Book> books = repository.getAllBooks();
        
        System.out.println(books.size());
        model.addAttribute("books",books);
        return "viewbookuser";

}


}
