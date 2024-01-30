package com.example.EcommerceMVC.mapper;

import com.example.EcommerceMVC.dto.ElectronicDTO;
import com.example.EcommerceMVC.dto.FashionDTO;
import com.example.EcommerceMVC.entity.Electronic;
import com.example.EcommerceMVC.entity.Fashion;

public class FashionMapper {
    public static FashionDTO mapToFashionDto(Fashion fashion){
        FashionDTO fashionDTO = new FashionDTO(
                fashion.getId(),
                fashion.getBrand(),
                fashion.getDescription(),
                fashion.getPrice(),
                fashion.getSize(),
                fashion.getColor(),
                fashion.getMaterial(),
                fashion.getGender(),
                fashion.getFashionType(),
                fashion.getImageURL()
        );
        return fashionDTO;
    }

    public static Fashion mapToFashion(FashionDTO fashionDTO){
        Fashion fashion = new Fashion(
                fashionDTO.getId(),
                fashionDTO.getBrand(),
                fashionDTO.getDescription(),
                fashionDTO.getPrice(),
                fashionDTO.getSize(),
                fashionDTO.getColor(),
                fashionDTO.getMaterial(),
                fashionDTO.getGender(),
                fashionDTO.getFashionType(),
                fashionDTO.getImageURL()
        );
        return fashion;
    }
}
