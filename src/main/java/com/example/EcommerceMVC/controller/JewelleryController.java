package com.example.EcommerceMVC.controller;

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
    public List<JewelleryDTO> getAllJewellerty(Model model){
        List<JewelleryDTO> allJewelleryDTO = jewelleryService.getAllJewellery();
        model.addAttribute("allJewelleryDTOList",allJewelleryDTO);
        return allJewelleryDTO;
    }
    @GetMapping("/jewellery/{id}")
    public JewelleryDTO getJewellertyById(@PathVariable Integer id, Model model){
        JewelleryDTO jewelleryDTO = jewelleryService.getJewelleryById(id);
        model.addAttribute("jewelleryDTO",jewelleryDTO);
        return jewelleryDTO;
    }
    @PostMapping("/admin/jewellery")
    public JewelleryDTO createJewellerty(@RequestBody JewelleryDTO jewelleryDTO){
        JewelleryDTO jewelleryDTOCreated = jewelleryService.createJewellery(jewelleryDTO);
        return jewelleryDTOCreated;
    }
    @PutMapping("/admin/jewellery")
    public JewelleryDTO updateJewellery(@RequestBody JewelleryDTO jewelleryDTO) {
        JewelleryDTO jewelleryUpdated = jewelleryService.updateJewellery(jewelleryDTO);
        return jewelleryUpdated;
    }
    @DeleteMapping("/admin/jewellery/{id}")
    public void deleteJewelleryById(@PathVariable Integer id) {
        jewelleryService.deleteJewellery(id);
    }
}
