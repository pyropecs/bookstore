package com.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.library.dto.AdduserToBookForm;
import com.library.models.Book;
import com.library.repositories.BookRepository;

@Controller
public class BookController {

    @Autowired
    private BookRepository repository;

    @GetMapping("/books")
    public String getCreateBookPage(Model model) {
        model.addAttribute("path", "books");
        return "createform";
    }

    @PostMapping("/books/add")
    public String createBook(@ModelAttribute Book book, RedirectAttributes redirectAttributes) {

        String message;
        try {
        repository.insertBook(book);
        message ="Book Created Successfully" ;
        } catch (Exception e) {
            System.out.println("something went wrong UserController.createUser()");
            System.out.println(e.getMessage());
            e.printStackTrace();
            message = "Internal Server Error";
        }
        redirectAttributes.addFlashAttribute("message", message);
        redirectAttributes.addFlashAttribute("path","books");
        return "redirect:/books";
    }

    @PostMapping("/addusers/insert")
    public String insertUsersToBook(@ModelAttribute AdduserToBookForm form, RedirectAttributes redirectAttributes) {
        String message;
        try {
            repository.insertUsersToBook(form.getBookId(), form.getUserIds());
            
           message="Users added to the book sucessfully";
        } catch (Exception e) {
            System.out.println("Exception occured:" + "AddUserBookController.insertUsersToBook()");
            e.printStackTrace();
            message = "Internal Server Error";
            
        }
        redirectAttributes.addFlashAttribute("message",message);
        return "redirect:/addusers";
    }

}
