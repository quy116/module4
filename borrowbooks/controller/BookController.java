package com.example.borrowbooks.controller;

import com.example.borrowbooks.model.Book;
import com.example.borrowbooks.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    IBookService bookService;

    @GetMapping
    public String library(Model model) {
        List<Book> list = bookService.library();
        model.addAttribute("list", list);
        return "/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.getById(id));
        return "/detail";
    }
}
