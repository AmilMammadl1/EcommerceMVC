package com.example.EcommerceMVC.mapper;

import com.example.EcommerceMVC.dto.FashionDTO;
import com.example.EcommerceMVC.dto.JewelleryDTO;
import com.example.EcommerceMVC.entity.Fashion;
import com.example.EcommerceMVC.entity.Jewellery;

public class JewelleryMapper {
    public static JewelleryDTO mapToJewelleryDto(Jewellery jewellery){
        JewelleryDTO jewelleryDTO = new JewelleryDTO(
                jewellery.getId(),
                jewellery.getBrand(),
                jewellery.getDescription(),
                jewellery.getPrice(),
                jewellery.getMaterial(),
                jewellery.getJewelleryType(),
                jewellery.getImageURL()
        );
        return jewelleryDTO;
    }

    public static Jewellery mapToJewellery(JewelleryDTO jewelleryDTO){
        Jewellery jewellery = new Jewellery(
                jewelleryDTO.getId(),
                jewelleryDTO.getBrand(),
                jewelleryDTO.getDescription(),
                jewelleryDTO.getPrice(),
                jewelleryDTO.getMaterial(),
                jewelleryDTO.getJewelleryType(),
                jewelleryDTO.getImageURL()
        );
        return jewellery;
    }
}
