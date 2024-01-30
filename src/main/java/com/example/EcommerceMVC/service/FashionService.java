package com.example.EcommerceMVC.service;

import com.example.EcommerceMVC.dto.FashionDTO;
import com.example.EcommerceMVC.dto.JewelleryDTO;
import com.example.EcommerceMVC.entity.Fashion;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface FashionService {
    FashionDTO createFashion(FashionDTO fashionDTO);

    FashionDTO getFashionById(Integer fashionId);

    List<FashionDTO> getAllFashion();

    FashionDTO updateFashion(FashionDTO fashionDTO);

    void deleteFashion(Integer fashionId);
}
