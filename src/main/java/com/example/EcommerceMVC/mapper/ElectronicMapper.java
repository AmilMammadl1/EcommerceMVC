package com.example.EcommerceMVC.mapper;

import com.example.EcommerceMVC.dto.ElectronicDTO;
import com.example.EcommerceMVC.entity.Electronic;

public class ElectronicMapper {
    public static ElectronicDTO mapToElectronicDto(Electronic electronic){
        ElectronicDTO electronicDTO = new ElectronicDTO(
                electronic.getId(),
                electronic.getBrand(),
                electronic.getDescription(),
                electronic.getPrice(),
                electronic.getModel(),
                electronic.getStorageCapacityGB(),
                electronic.getRamSizeGB(),
                electronic.getScreenSizeInch(),
                electronic.getElectronicType(),
                electronic.getImageURL()
        );
        return electronicDTO;
    }

    public static Electronic mapToElectronic(ElectronicDTO electronicDTO){
        Electronic user = new Electronic(
                electronicDTO.getId(),
                electronicDTO.getBrand(),
                electronicDTO.getDescription(),
                electronicDTO.getPrice(),
                electronicDTO.getModel(),
                electronicDTO.getStorageCapacityGB(),
                electronicDTO.getRamSizeGB(),
                electronicDTO.getScreenSizeInch(),
                electronicDTO.getElectronicType(),
                electronicDTO.getImageURL()
        );
        return user;
    }
}
