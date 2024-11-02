package com.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.library.models.Book;
import com.library.repositories.BookRepository;

import java.util.List;

@Controller
public class AddUserBookController {

@Autowired        
private BookRepository repository;

@GetMapping("/addusers")
public String getAddUserToPage(Model model){
        List<Book> books = repository.getAllBooks();
        
        model.addAttribute("books",books);
        
        return "addusertobook";
}


        

}
