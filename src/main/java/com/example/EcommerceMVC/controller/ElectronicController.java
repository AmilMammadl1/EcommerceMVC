package com.example.EcommerceMVC.controller;

import com.example.EcommerceMVC.dto.ElectronicDTO;
import com.example.EcommerceMVC.service.ElectronicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ElectronicController {
    @Autowired
    private ElectronicService electronicService;

    @GetMapping("/electronics")
    public List<ElectronicDTO> getAllElectronic(Model model){
        List<ElectronicDTO> allElectronicDTO = electronicService.getAllElectronic();
        model.addAttribute("allElectronicDTOList",allElectronicDTO);
        return allElectronicDTO;
    }
    @GetMapping("/electronics/{id}")
    public ElectronicDTO getElectronicById(@PathVariable Integer id,Model model){
        ElectronicDTO ElectronicDTO = electronicService.getElectronicById(id);
        model.addAttribute("ElectronicDTO",ElectronicDTO);
        return ElectronicDTO;
    }
    @PostMapping("/admin/electronics")
    public ElectronicDTO createElectronic(@RequestBody ElectronicDTO electronicDTO ){
        ElectronicDTO electronicDtoCreated = electronicService.createElectronic(electronicDTO);
        return electronicDtoCreated;
    }
    @PutMapping("/admin/electronics")
    public ElectronicDTO updateElectronic(@RequestBody ElectronicDTO electronicDTO){
        ElectronicDTO electronicDtoCreated = electronicService.updateElectronic(electronicDTO);
        return electronicDtoCreated;
    }
    @DeleteMapping("/admin/electronics/{id}")
    public void deleteElectronicById(@PathVariable Integer id){
        electronicService.deleteElectronic(id);
    }
}
