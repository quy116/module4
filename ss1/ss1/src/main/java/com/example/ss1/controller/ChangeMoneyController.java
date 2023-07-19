package com.example.ss1.controller;

import com.example.ss1.service.IMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangeMoneyController {
    @Autowired
    private IMoneyService moneyService;
    @PostMapping("/changeMoney")
    public String changeMoney(@RequestParam int dola, Model model) {
        double result = moneyService.changeMoney(dola);
        model.addAttribute("result", result);
        return "changeMoney";
    }
    @GetMapping("/ChangeMoney")
    public String showForm(){
        return "changeMoney";
    }
}
