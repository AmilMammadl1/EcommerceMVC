package com.example.EcommerceMVC.dto;

import com.example.EcommerceMVC.constant.FashionType;
import com.example.EcommerceMVC.constant.GenderType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FashionDTO {
    private int id;
    private String brand;
    private String description;
    private float price;
    private String size;
    private String color;
    private String material;
    private GenderType gender;
    private FashionType fashionType;
    private String imageURL;
}