package com.example.EcommerceMVC.dto;

import com.example.EcommerceMVC.constant.JewelleryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JewelleryDTO {
    private int id;
    private String brand;
    private String description;
    private float price;
    private String material;
    private JewelleryType jewelleryType;
    private String imageURL;
}