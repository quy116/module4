package com.example.bai2.controller;

import com.example.bai2.service.ITranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TranslateController {
    @Autowired
    private ITranslateService translateService;

    @GetMapping("/")
    public String showList() {
        return "List";
    }

    @PostMapping("find")
    public String find(@RequestParam String find, Model model) {
        String result = translateService.translate(find);
        model.addAttribute("result", result);
        return "List";
    }
}
