package com.example.EcommerceMVC.controller;

import com.example.EcommerceMVC.dto.UserDTO;
import com.example.EcommerceMVC.entity.User;
import com.example.EcommerceMVC.service.UserService;
import jakarta.validation.Valid;
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
        User u = userService.findByUserByEmail(userDTO.getEmail());
        if(u!=null){
            bindingResult.rejectValue("email", null,"This email is already used");
        }
        if(bindingResult.hasErrors()){
            model.addAttribute("user",userDTO);
            return "/register";
        }

        userService.saveUser(userDTO);
        return "redirect:/register?success";
    }


}
