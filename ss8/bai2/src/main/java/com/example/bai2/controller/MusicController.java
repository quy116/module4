package com.example.bai2.controller;

import com.example.bai2.dto.Dto;
import com.example.bai2.model.Music;
import com.example.bai2.service.IMusicService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MusicController {
    @Autowired
    IMusicService iMusicService;

    @GetMapping("/")
    public String showList(Model model) {
        List<Music> listMusic = iMusicService.showList();
        Dto dto = new Dto();
        model.addAttribute("listMusic", listMusic);
        model.addAttribute("dto", dto);
        model.addAttribute("dto", new Dto());
        return "index";
    }
    @GetMapping("/ShowCreate")
    public String showCreate(Model model) {
        Dto dto = new Dto();
        model.addAttribute("dto", dto);
        model.addAttribute("dto", new Dto());
        return "create";
    }
    @PostMapping("/create")
    public String showCreate(@Valid @ModelAttribute Dto dto, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        Music music = new Music();
        new Dto().validate(dto,bindingResult);
        if (bindingResult.hasErrors()){
            return "create";
        }
        BeanUtils.copyProperties(dto,music);
        iMusicService.save(music);
        return "redirect:/";
    }

}
