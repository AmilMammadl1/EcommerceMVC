package com.example.EcommerceMVC.entity;

import com.example.EcommerceMVC.constant.JewelleryType;
import jakarta.persistence.*;

@Entity
public class Jewellery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String description;
    private float price;
    private String material;
    @Enumerated(EnumType.STRING)
    private JewelleryType jewelleryType;
    private String imageURL;

    public Jewellery() {
    }

    public Jewellery(int id, String brand, String description, float price, String material, JewelleryType jewelleryType, String imageURL) {
        this.id = id;
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.material = material;
        this.jewelleryType = jewelleryType;
        this.imageURL = imageURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }


    public JewelleryType getJewelleryType() {
        return jewelleryType;
    }

    public void setJewelleryType(JewelleryType jewelleryType) {
        this.jewelleryType = jewelleryType;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
