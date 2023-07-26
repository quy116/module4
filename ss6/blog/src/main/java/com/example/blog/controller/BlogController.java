package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService service;


    @GetMapping("/")
    public String showList(Model model) {
        List<Blog> list = service.showList();
        model.addAttribute("list", list);
        model.addAttribute("blog", new Blog());
        return "index";
    }

    @PostMapping("create")
    public String add(Blog blog) {
        service.add(blog);
        return "redirect:/";
    }

    @GetMapping("delete")
    public String delete(@RequestParam int id, Model model) {
        service.deleteFindId(id);
        return "redirect:/";
    }

    @GetMapping("showEdit")
    public String showEdit(@RequestParam Integer id, Model model) {
        Blog blog = service.editfindId(id);
        model.addAttribute("blog",blog);
        return "edit";
    }
    @PostMapping("edit")
    public String edit(Blog blog) {
        service.edit(blog);
        return "redirect:/";
    }
}
