package com.example.bai1.controller;

import com.example.bai1.model.Product;
import com.example.bai1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/")
    public String showList(Model model) {
        List<Product> list = productService.ShowList();
        model.addAttribute("list", list);
        return "index";
    }

    @GetMapping("ShowCreate")
    public String showCreate(@ModelAttribute("product") Product product) {

        return "create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute Product product) {
        productService.createSerivce(product);
        return "redirect:/";
    }

    @GetMapping("showEdit")
    public String showEdit(@RequestParam int id, Model model) {
        Product product = productService.getProduct(id);
        model.addAttribute("product", product);
        return "edit";
    }

    @PostMapping("edit")
    public String edit(@ModelAttribute Product product) {
        System.out.println(product);
        productService.edit(product);
        return "redirect:/";
    }

    @GetMapping("delete")
    public String delete(@RequestParam int id) {
        productService.delete(id);
        return "redirect:/";
    }

    @PostMapping("findName")
    public String findName(@RequestParam String name, Model model) {
        Product product = productService.findName(name);
        model.addAttribute("product",product);
        return "find";
    }


}
