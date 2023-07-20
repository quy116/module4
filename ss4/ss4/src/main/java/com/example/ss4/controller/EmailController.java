package com.example.ss4.controller;

import com.example.ss4.model.Email;
import com.example.ss4.service.EmailService;
import com.example.ss4.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmailController {
    @Autowired
    private IEmailService iEmailService;

    @RequestMapping("/")
    public String showList(Model model) {
        Email email = iEmailService.showListService();
        model.addAttribute("email", email);
        return "home";
    }
    @GetMapping("showForm")
    public String showFormEdit(@ModelAttribute("email") Email email){
        return "edit";
    }
    @PostMapping("edit")
    public String edit(@ModelAttribute("email") Email email){
        iEmailService.edit(email);
        return "home";
    }
    @ModelAttribute("languages")
    public String[] languages(){
        return new String[]{"English","Vietnamese","Japanese","Chinese"};
    }
    @ModelAttribute("size")
    public String[] size(){
        return new String[]{"5","10","15","20"};
    }
}
