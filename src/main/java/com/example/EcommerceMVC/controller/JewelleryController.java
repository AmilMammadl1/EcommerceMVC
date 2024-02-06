package com.example.EcommerceMVC.controller;

import com.example.EcommerceMVC.dto.ElectronicDTO;
import com.example.EcommerceMVC.dto.FashionDTO;
import com.example.EcommerceMVC.dto.JewelleryDTO;
import com.example.EcommerceMVC.entity.Jewellery;
import com.example.EcommerceMVC.repository.JewelleryRepository;
import com.example.EcommerceMVC.service.JewelleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class JewelleryController {
    @Autowired
    private JewelleryService jewelleryService;

    @GetMapping("/jewellery")
    public String getAllJewellerty(Model model) {
        List<JewelleryDTO> allJewelleryDTO = jewelleryService.getAllJewellery();
        model.addAttribute("allJewelleryDTOList", allJewelleryDTO);
        return "index";
    }

    @GetMapping("/jewellery/{id}")
    public JewelleryDTO getJewellertyById(@PathVariable Integer id, Model model) {
        JewelleryDTO jewelleryDTO = jewelleryService.getJewelleryById(id);
        model.addAttribute("jewelleryDTO", jewelleryDTO);
        return jewelleryDTO;
    }

    @GetMapping("/admin/create/jewellery.html")
    public String jewelleryCreatePage(Model model) {
        JewelleryDTO jewelleryDTO = new JewelleryDTO();
        model.addAttribute("jewelleryForm", jewelleryDTO);

        return "admin/CreateJewellery";
    }
    @GetMapping("/admin/update/jewellery/{id}")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        JewelleryDTO jewelleryDTOById = jewelleryService.getJewelleryById(id);
        model.addAttribute("jewellery", jewelleryDTOById);
        return "admin/updateJewellery"; // Thymeleaf template name
    }

    @PostMapping("/admin/jewellery")
    public String createJewellerty(@ModelAttribute("jewelleryForm") JewelleryDTO jewelleryDTO) {
        JewelleryDTO jewelleryDTOCreated = jewelleryService.createJewellery(jewelleryDTO);
        return "redirect:/admin"; // Redirect to the "/admin" mapping in AdminController
    }

    @PutMapping("/admin/jewellery")
    public String updateJewellery(@ModelAttribute("jewellery") JewelleryDTO jewelleryDTO) {
        JewelleryDTO jewelleryUpdated = jewelleryService.updateJewellery(jewelleryDTO);
        return "redirect:/admin"; // Redirect to the home page or any other appropriate page
    }

    @DeleteMapping("/admin/jewellery/{id}")
    public String deleteJewelleryById(@PathVariable Integer id) {
        jewelleryService.deleteJewellery(id);
        return "redirect:/admin"; // Redirect to the home page or any other appropriate page
    }
}
