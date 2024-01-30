package com.example.EcommerceMVC.service;

import com.example.EcommerceMVC.dto.ElectronicDTO;
import com.example.EcommerceMVC.dto.FashionDTO;
import com.example.EcommerceMVC.entity.Electronic;

import java.util.List;

public interface ElectronicService {
    ElectronicDTO createElectronic(ElectronicDTO electronicDTO);

    ElectronicDTO getElectronicById(Integer electronicId);

    List<ElectronicDTO> getAllElectronic();

    ElectronicDTO updateElectronic(ElectronicDTO electronicDTO);

    void deleteElectronic(Integer electronicId);
}
