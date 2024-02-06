package com.example.EcommerceMVC.controller;

import com.example.EcommerceMVC.dto.ElectronicDTO;
import com.example.EcommerceMVC.dto.FashionDTO;
import com.example.EcommerceMVC.entity.Fashion;
import com.example.EcommerceMVC.service.FashionService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FashionController {
    @Autowired
    private FashionService fashionService;
    private static final Logger logger = LoggerFactory.getLogger(FashionController.class);


    @GetMapping("/fashion")
    public String getAllFashions(Model model) {
        List<FashionDTO> allFashionDTO = fashionService.getAllFashion();
        model.addAttribute("allFashionDTOList", allFashionDTO);

        for (FashionDTO fashionDTO : allFashionDTO) {
            logger.info("Image URL for Fashion ID {}: {}", fashionDTO.getId(), fashionDTO.getImageURL());
        }
        return "index";
    }


    @GetMapping("/fashion/{id}")
    public FashionDTO getFashionById(@PathVariable Integer id, Model model) {
        FashionDTO fashionDTO = fashionService.getFashionById(id);
        model.addAttribute("fashionDTO", fashionDTO);
        return fashionDTO;
    }

    @GetMapping("/admin/create/fashion.html")
    public String fashionCreatePage(Model model) {
        FashionDTO fashionDTO = new FashionDTO();
        model.addAttribute("fashionForm", fashionDTO);

        return "admin/CreateFashion";
    }
    @GetMapping("/admin/update/fashion/{id}")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        FashionDTO fashionDTOById = fashionService.getFashionById(id);
        model.addAttribute("fashion", fashionDTOById);
        return "admin/updateFashion"; // Thymeleaf template name
    }

    @PostMapping("/admin/fashion")
    public String createFashion(@ModelAttribute("fashionForm") FashionDTO fashionDTO) {
        System.out.println("Received FashionDTO: " + fashionDTO);
        FashionDTO fashionCreated = fashionService.createFashion(fashionDTO);
        System.out.println("Fashion Created: " + fashionCreated);

        return "redirect:/admin"; // Redirect to the "/admin" mapping in AdminController
    }

    @PutMapping("/admin/fashion")
    public String updateFashion(@ModelAttribute("fashion") FashionDTO fashionDTO) {
        FashionDTO fashionUpdated = fashionService.updateFashion(fashionDTO);
        return "redirect:/admin"; // Redirect to the "/admin" mapping in AdminController
    }

    @DeleteMapping("/admin/fashion/{id}")
    public String deleteFashionById(@PathVariable Integer id) {
        fashionService.deleteFashion(id);
        return "redirect:/admin"; // Redirect to the home page or any other appropriate page
    }

}
