package com.learn.spring5webapp.controllers;

import com.learn.spring5webapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    //Model is Spring Framework interface,
    // Spring Framework will find the appropriate implementation at runtime
    @RequestMapping("/allBooks")
    public String getAllBooks(Model model) {
        //Instructing spring to add an attribute to the model named "allBooks" which has all the list of books
        model.addAttribute("allBooks", bookRepository.findAll());
        //Tells Spring to associate this with a view called "allBooks"
        //Name of Thymeleaf template should be same as returned here
        return "allBooks";
    }
}
