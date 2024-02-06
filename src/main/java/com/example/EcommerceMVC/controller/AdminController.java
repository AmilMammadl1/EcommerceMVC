package com.example.EcommerceMVC.controller;

import com.example.EcommerceMVC.dto.ElectronicDTO;
import com.example.EcommerceMVC.dto.FashionDTO;
import com.example.EcommerceMVC.dto.JewelleryDTO;
import com.example.EcommerceMVC.service.ElectronicService;
import com.example.EcommerceMVC.service.FashionService;
import com.example.EcommerceMVC.service.JewelleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private ElectronicService electronicService;
    @Autowired
    private FashionService fashionService;
    @Autowired
    private JewelleryService jewelleryService;

    @GetMapping("/admin")
    public String adminPanel(Model model) {
        // Fetch electronic data and add it to the model
        List<ElectronicDTO> allElectronicDTO = electronicService.getAllElectronic();
        model.addAttribute("allElectronicDTOList", allElectronicDTO);

        List<FashionDTO> allFashionDTO = fashionService.getAllFashion();
        model.addAttribute("allFashionDTOList", allFashionDTO);

        List<JewelleryDTO> allJewelleryDTO = jewelleryService.getAllJewellery();
        model.addAttribute("allJewelleryDTOList", allJewelleryDTO);

        // You can add other attributes to the model if needed

        // Return the name of the Thymeleaf template for the admin panel
        return "admin/indexAdmin";
    }
}
