package com.example.player.controller;


import com.example.player.model.PlayerSoccer;
import com.example.player.model.Team;
import com.example.player.service.IPlayerService;
import com.example.player.service.ITeamService;
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
    @Autowired
    private ITeamService iTeamService;

    @GetMapping("/")
    public String showList(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String searchName,
                           @RequestParam(defaultValue = "2") int size,
                           Model model) {
        int size1 = size;
        Pageable pageable = (Pageable) PageRequest.of(page, size1, Sort.by("fullName").ascending());
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

        PlayerSoccer playerSoccer = iPlayerService.findById(id).get();

        model.addAttribute("playerSoccer", playerSoccer);
        return "detail";
    }

    @GetMapping("/showCreate")
    public String ShowCreate(Model model) {
        model.addAttribute("player", new PlayerSoccer());
        model.addAttribute("team", iTeamService.ShowTeam());
        return "showCreate";
    }

    @PostMapping("create")
    public String create(PlayerSoccer playerSoccer, Team team) {
        iPlayerService.add(playerSoccer);
//        iTeamService.add(team);
        return "redirect:/";
    }

    @GetMapping("showEdit")
    public String showEdit(@RequestParam int id, Model model) {
        PlayerSoccer playerSoccer = iPlayerService.edit(id);
        model.addAttribute("playerSoccer", playerSoccer);
        model.addAttribute("team", iTeamService.ShowTeam());
        return "edit";
    }

    @PostMapping("edit")
    public String edit(PlayerSoccer playerSoccer) {
        iPlayerService.editTwo(playerSoccer, playerSoccer.getId());
        return "redirect:/";
    }
}
