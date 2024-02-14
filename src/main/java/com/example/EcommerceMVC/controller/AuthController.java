package com.example.EcommerceMVC.controller;

import com.example.EcommerceMVC.dto.UserDTO;
import com.example.EcommerceMVC.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public String getToLoginPage(Model model) {
        return "login";
    }

    @GetMapping("/register")
    public String getToRegisterPage(Model model) {
        UserDTO userDTO = new UserDTO();
        model.addAttribute("user",userDTO);
        return "register";
    }
    @PostMapping("/register/save")
    public String toRegister(@Valid @ModelAttribute("user") UserDTO userDTO, BindingResult bindingResult, Model model){
        userService.saveUser(userDTO);
        return "redirect:/register?success";
    }


}
