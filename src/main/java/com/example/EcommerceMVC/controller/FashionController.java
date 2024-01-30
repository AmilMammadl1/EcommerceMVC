package com.example.EcommerceMVC.controller;

import com.example.EcommerceMVC.dto.FashionDTO;
import com.example.EcommerceMVC.entity.Fashion;
import com.example.EcommerceMVC.service.FashionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FashionController {
    @Autowired
    private FashionService fashionService;

    @GetMapping("/fashion")
    public List<FashionDTO> getAllFashions(Model model) {
        List<FashionDTO> allFashionDTO = fashionService.getAllFashion();
        model.addAttribute("allFashionDTOList", allFashionDTO);
        return allFashionDTO;
    }

    @GetMapping("/fashion/{id}")
    public FashionDTO getFashionById(@PathVariable Integer id, Model model) {
        FashionDTO fashionDTO = fashionService.getFashionById(id);
        model.addAttribute("fashionDTO", fashionDTO);
        return fashionDTO;
    }

    @PostMapping("/admin/fashion")
    public FashionDTO createFashion(@RequestBody FashionDTO fashionDTO) {
        FashionDTO fashionCreated = fashionService.createFashion(fashionDTO);
        return fashionCreated;
    }
    @PutMapping("/admin/fashion")
    public FashionDTO updateFashion(@RequestBody FashionDTO fashionDTO) {
        FashionDTO fashionUpdated = fashionService.updateFashion(fashionDTO);
        return fashionUpdated;
    }
    @DeleteMapping("/admin/fashion/{id}")
    public void deleteFashionById(@PathVariable Integer id) {
         fashionService.deleteFashion(id);
    }

}
