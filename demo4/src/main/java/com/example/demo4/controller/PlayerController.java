package com.example.demo4.controller;

import com.example.demo4.model.PlayerSoccer;
import com.example.demo4.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PlayerController {
    @Autowired
    private IPlayerService iPlayerService;

    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("list", iPlayerService.showListService());
        return "/index";
    }

    @GetMapping("delete")
    public String delete(@RequestParam int id, Model model) {
        iPlayerService.delete(id);
        return "redirect:/";
    }

    @GetMapping("detail")
    public String detail(@RequestParam int id, Model model) {
        List<PlayerSoccer> list = iPlayerService.findById(id);
        model.addAttribute("list", list);
        return "/index";
    }

    @GetMapping("/showCreate")
    public String ShowCreate(Model model) {
        model.addAttribute("player", new PlayerSoccer());
        return "showCreate";
    }

    @PostMapping("create")
    public String create(PlayerSoccer playerSoccer) {
        iPlayerService.add(playerSoccer);
        return "redirect:/";
    }

    @GetMapping("showEdit")
    public String showEdit(@RequestParam int id, Model model) {
        PlayerSoccer playerSoccer = iPlayerService.edit(id);
        model.addAttribute("playerSoccer", playerSoccer);
        return "edit";
    }
    @PostMapping("edit")
    public String edit(PlayerSoccer playerSoccer) {
        iPlayerService.editTwo(playerSoccer, playerSoccer.getId());
        return "redirect:/";
    }
}
