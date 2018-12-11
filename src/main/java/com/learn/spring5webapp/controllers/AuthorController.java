package com.learn.spring5webapp.controllers;

import com.learn.spring5webapp.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @RequestMapping("allAuthors")
    public String getAllAuthors(Model model) {
        model.addAttribute("allAuthors", authorRepository.findAll());
        return "allAuthors";
    }
}
