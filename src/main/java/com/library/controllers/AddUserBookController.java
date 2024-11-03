package com.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.library.models.Book;
import com.library.models.User;
import com.library.dto.AdduserToBookForm;
import com.library.repositories.BookRepository;
import com.library.repositories.UserRepository;

import java.net.URI;
import java.util.List;
import java.util.StringTokenizer;

@Controller
public class AddUserBookController {

@Autowired        
private BookRepository repository;

@Autowired
private UserRepository userRepository;

@GetMapping("/addusers")
public String getAddUserToPage(Model model){
        List<Book> books = repository.getAllBooks();
        List<User> users = userRepository.getAllUsers();
        System.out.println(books.size());
        model.addAttribute("books",books);
        model.addAttribute("users",users);        
        return "addusertobook";
}

@PostMapping("/addusers/insert")
public String insertUsersToBook(AdduserToBookForm form){


        System.out.println("books ID" +form.getBookId());
        System.out.println("users Id" + form.getUserIds());
        repository.insertUsersToBook(form.getBookId(), form.getUserIds());
return "redirect:/";
}

        

}
