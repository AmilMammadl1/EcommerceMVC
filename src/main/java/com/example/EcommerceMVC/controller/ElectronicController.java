package com.example.EcommerceMVC.controller;

import com.example.EcommerceMVC.dto.ElectronicDTO;
import com.example.EcommerceMVC.entity.Electronic;
import com.example.EcommerceMVC.service.ElectronicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ElectronicController {
    @Autowired
    private ElectronicService electronicService;

    @GetMapping("/electronics")
    public String getAllElectronic(Model model) {
        List<ElectronicDTO> allElectronicDTO = electronicService.getAllElectronic();
        model.addAttribute("allElectronicDTOList", allElectronicDTO);
        return "index";
    }

    @GetMapping("/electronics/{id}")
    public ElectronicDTO getElectronicById(@PathVariable Integer id, Model model) {
        ElectronicDTO ElectronicDTO = electronicService.getElectronicById(id);
        model.addAttribute("ElectronicDTO", ElectronicDTO);
        return ElectronicDTO;
    }
    @GetMapping("/admin/update/electronics/{id}")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        ElectronicDTO electronicDTOById = electronicService.getElectronicById(id);
        model.addAttribute("electronic", electronicDTOById);
        return "admin/updateElectronic"; // Thymeleaf template name
    }

    @GetMapping("/admin/create/electronics.html")
    public String showCreatePage(Model model) {
        ElectronicDTO electronicDTO = new ElectronicDTO();
        model.addAttribute("electronicForm", electronicDTO);

        return "admin/CreateElectronic";
    }

    @PostMapping("/admin/electronics")
    public String createElectronic(@ModelAttribute("electronicForm") ElectronicDTO electronicDTO, Model model) {
        ElectronicDTO electronicDtoCreated = electronicService.createElectronic(electronicDTO);

        model.addAttribute("electronic", electronicDtoCreated);
        return "redirect:/admin"; // Redirect to the "/admin" mapping in AdminController
    }

    @PutMapping("/admin/electronics")
    public String updateElectronic(@ModelAttribute("electronic") ElectronicDTO electronicDTO) {
        ElectronicDTO electronicDtoCreated = electronicService.updateElectronic(electronicDTO);
        return "redirect:/admin";
    }

    @DeleteMapping("/admin/electronics/{id}")
    public String deleteElectronicById(@PathVariable Integer id) {
        electronicService.deleteElectronic(id);
        return "redirect:/admin"; // Redirect to the home page or any other appropriate page
    }
}
