package com.example.EcommerceMVC.entity;

import com.example.EcommerceMVC.constant.ElectronicType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Electronic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String description;
    private float price;
    private String model;
    private int storageCapacityGB;
    private int ramSizeGB;
    private double screenSizeInch;
    @Enumerated(EnumType.STRING)
    private ElectronicType electronicType;
    private String imageURL;

    public Electronic() {
    }

    public Electronic(int id, String brand, String description, float price, String model, int storageCapacityGB, int ramSizeGB, double screenSizeInch, ElectronicType electronicType, String imageURL) {
        this.id = id;
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.model = model;
        this.storageCapacityGB = storageCapacityGB;
        this.ramSizeGB = ramSizeGB;
        this.screenSizeInch = screenSizeInch;
        this.electronicType = electronicType;
        this.imageURL = imageURL;
    }
}
