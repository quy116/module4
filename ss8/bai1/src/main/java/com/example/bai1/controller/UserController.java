package com.example.bai1.controller;

import com.example.bai1.dto.DtoUser;
import com.example.bai1.model.User;
import com.example.bai1.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("/")
    public String RegistrationForm(Model model) {
        User user = new User();
        DtoUser dtoUser = new DtoUser();
        model.addAttribute("dtoUser", dtoUser);
        model.addAttribute("dtoUser", new DtoUser());
        return "index";
    }

    @PostMapping("create")
    public String create(@Valid @ModelAttribute DtoUser dtoUser, BindingResult bindingResult
            , RedirectAttributes redirectAttributes) {
        User user = new User();
        new DtoUser().validate(dtoUser, bindingResult);
        if (bindingResult.hasErrors()) {
            return "index";
        }
        BeanUtils.copyProperties(dtoUser, user);
        iUserService.save(user);
        return "create";
    }
}
