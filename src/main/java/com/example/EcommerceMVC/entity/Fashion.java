package com.example.EcommerceMVC.entity;

import com.example.EcommerceMVC.constant.FashionType;
import com.example.EcommerceMVC.constant.GenderType;
import jakarta.persistence.*;

@Entity
public class Fashion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String description;
    private float price;
    private String size;
    private String color;
    private String material;
    @Enumerated(EnumType.STRING)
    private GenderType gender;
    @Enumerated(EnumType.STRING)
    private FashionType fashionType;
    private String imageURL;

    public Fashion() {
    }

    public Fashion(int id, String brand, String description, float price, String size, String color, String material, GenderType gender, FashionType fashionType, String imageURL) {
        this.id = id;
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.size = size;
        this.color = color;
        this.material = material;
        this.gender = gender;
        this.fashionType = fashionType;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public FashionType getFashionType() {
        return fashionType;
    }

    public void setFashionType(FashionType fashionType) {
        this.fashionType = fashionType;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
