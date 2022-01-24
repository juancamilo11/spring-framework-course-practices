package dev.j3c.practice.controllers;

import dev.j3c.practice.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/get/books")
    public String getAllBooks(Model model) {
        model.addAttribute("books", this.bookRepository.findAll());
        return "books/list";
    }



}
