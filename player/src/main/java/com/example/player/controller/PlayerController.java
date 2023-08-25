package com.example.player.controller;


import com.example.player.dto.DtoPlayer;
import com.example.player.model.PlayerSoccer;
import com.example.player.service.IPlayerService;
import com.example.player.service.IPositionService;
import com.example.player.service.IStatusService;
import com.example.player.service.ITeamService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class PlayerController {
    @Autowired
    private IPlayerService iPlayerService;
    @Autowired
    private ITeamService iTeamService;
    @Autowired
    private IPositionService iPositionService;
    @Autowired
    IStatusService iStatusService;

    @GetMapping("/")
    public String showList(@RequestParam(defaultValue = "0",required = false) int page,
                           @RequestParam(defaultValue = "",required = false) String searchName,
                           @RequestParam(defaultValue = "2",required = false) int size,
                           Model model) {
        Pageable pageable =  PageRequest.of(page, size, Sort.by("fullName").ascending());
        Page<PlayerSoccer> playerSoccer = iPlayerService.showListService(pageable);
        model.addAttribute("list", playerSoccer);
        model.addAttribute("size", size);
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
        model.addAttribute("player", new DtoPlayer());
        model.addAttribute("team", iTeamService.ShowTeam());
        model.addAttribute("list", iPositionService.list());
        model.addAttribute("status", iStatusService.list());
        return "showCreate";
    }

    @PostMapping("create")
    public String create(@Valid @ModelAttribute("player") DtoPlayer player, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        new DtoPlayer().validate(player, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("player", player);
            model.addAttribute("team", iTeamService.ShowTeam());
            model.addAttribute("list", iPositionService.list());
            model.addAttribute("status", iStatusService.list());
            return "showCreate";
        }
        PlayerSoccer playerSoccer = new PlayerSoccer();
        BeanUtils.copyProperties(player, playerSoccer);
        iPlayerService.add(playerSoccer);
        redirectAttributes.addFlashAttribute("mess", "them moi thanh cong");
//        iTeamService.add(team);
        return "redirect:/";
    }

    @GetMapping("showEdit")
    public String showEdit(
            @RequestParam int id, Model model) {
        PlayerSoccer playerSoccer = iPlayerService.edit(id);
        model.addAttribute("playerSoccer", playerSoccer);
        model.addAttribute("team", iTeamService.ShowTeam());
        model.addAttribute("list", iPositionService.list());
        model.addAttribute("status", iStatusService.list());
        return "edit";
    }

    @PostMapping("edit")
    public String edit(@Valid @ModelAttribute("playerSoccer") DtoPlayer playerSoccer, BindingResult bindingResult, Model model) {
        new DtoPlayer().validate(playerSoccer, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("player", playerSoccer);
            model.addAttribute("team", iTeamService.ShowTeam());
            model.addAttribute("list", iPositionService.list());
            model.addAttribute("status", iStatusService.list());
            return "edit";
        }
        PlayerSoccer playerSoccer1 = new PlayerSoccer();
        BeanUtils.copyProperties(playerSoccer, playerSoccer1);
        iPlayerService.editTwo(playerSoccer1, playerSoccer.getId());
        return "redirect:/";
    }
}
