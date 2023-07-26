package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.repository.ICategory;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService service;
    @Autowired
    private ICategoryService iCategory;


        @GetMapping("showList")
    public String showList( @RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "") String search
            ,Model model){
        Pageable pageable = PageRequest.of(page,2,Sort.by("date").descending());
        Page<Blog> blogPage = service.showList(pageable,search);
        model.addAttribute("blogPage", blogPage);
        model.addAttribute("search", search);
        model.addAttribute("blog", new Blog());
        model.addAttribute("category",iCategory.showList());
        return "index";
    }
//    @GetMapping("/showList")
//    public ModelAndView showList(@RequestParam(defaultValue = "0") int page,
//                                 @RequestParam(defaultValue = "") String search) {
//        Pageable pageable = PageRequest.of(page, 2);
//        Page<Blog> blogPage = service.showList(pageable);
//        ModelAndView modelAndView = new ModelAndView("index");
//        modelAndView.addObject("blogPage", blogPage);
//
//        return modelAndView;
//    }

    @PostMapping("create")
    public String add(Blog blog) {
        service.add(blog);
        return "redirect:showList";
    }

    @GetMapping("delete")
    public String delete(@RequestParam int id, Model model) {
        service.deleteFindId(id);
        return "redirect:showList";
    }

    @GetMapping("showEdit")
    public String showEdit(@RequestParam Integer id, Model model) {
        Blog blog = service.editfindId(id);
        model.addAttribute("blog", blog);
        model.addAttribute("category", iCategory.showList());
        return "edit";
    }

    @PostMapping("edit")
    public String edit(Blog blog) {
        service.edit(blog);
        return "redirect:showList";
    }
}
