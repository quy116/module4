package com.example.sandwich.Controller;

import com.example.sandwich.model.Spice;
import com.example.sandwich.service.ISpiceService;
import com.example.sandwich.service.SpiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SandWich {
    @Autowired

    private ISpiceService service;

    @GetMapping("/")
    public String showList(Model model) {
        List<Spice> list = service.showList();
        model.addAttribute("list", list);
        return "index";
    }

    @PostMapping()
    public String choice(@RequestParam String checkbox, Model model) {
        String arr = "";
        if (checkbox != null) {
            arr += checkbox;
        }
        model.addAttribute("arr", arr);
        return "index";
    }
}
