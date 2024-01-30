package com.example.EcommerceMVC.dto;

import com.example.EcommerceMVC.constant.ElectronicType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElectronicDTO {
    private int id;
    private String brand;
    private String description;
    private float price;
    private String model;
    private int storageCapacityGB;
    private int ramSizeGB;
    private double screenSizeInch;
    private ElectronicType electronicType;
    private String imageURL;
}