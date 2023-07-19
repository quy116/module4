package com.example.oprater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class operator {



    @GetMapping("/")
    public String show(){
        return "operator";
    }
    @PostMapping("operator")
    public String operator(@RequestParam int inputTop, @RequestParam int inputBottom, @RequestParam String result, Model model) {
        double sum = 0;
        if (result.equals("+")){
            sum = inputTop + inputBottom;
        } else if(result.equals("-")){
            sum = inputTop - inputBottom;
        } else if(result.equals("*")){
            sum = inputTop * inputBottom;
        }else {
            sum = inputTop / inputBottom;
        }
        model.addAttribute("sum", sum);
        return "operator";
    }
}
