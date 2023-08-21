package com.example.player.controller;


import com.example.player.model.PlayerSoccer;
import com.example.player.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class PlayerController {
    @Autowired
    private IPlayerService iPlayerService;

    @GetMapping("/")
    public String showList(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "") String searchName,
                           @RequestParam(defaultValue = "2") int size,
                           Model model) {
//        size = 2;
        Pageable pageable = (Pageable) PageRequest.of(page,size, Sort.by("fullName").ascending());
        Page<PlayerSoccer> playerSoccer = iPlayerService.showListService(pageable);
        model.addAttribute("list", playerSoccer);
        return "/index";
    }

    @GetMapping("delete")
    public String delete(@RequestParam int id, Model model) {
        iPlayerService.delete(id);
        return "redirect:/";
    }

    @GetMapping("detail")
    public String detail(@RequestParam int id, Model model) {
      PlayerSoccer playerSoccer = iPlayerService.findById(id);
      List<PlayerSoccer> list = new ArrayList<>();
      list.add(playerSoccer);
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
