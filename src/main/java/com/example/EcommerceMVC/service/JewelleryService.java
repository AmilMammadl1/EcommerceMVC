package com.example.EcommerceMVC.service;

import com.example.EcommerceMVC.dto.JewelleryDTO;
import com.example.EcommerceMVC.entity.Fashion;
import com.example.EcommerceMVC.entity.Jewellery;

import java.util.List;

public interface JewelleryService {
    JewelleryDTO createJewellery(JewelleryDTO jewelleryDTO);

    JewelleryDTO getJewelleryById(Integer jewelleryId);

    List<JewelleryDTO> getAllJewellery();

    JewelleryDTO updateJewellery(JewelleryDTO jewelleryDTO);

    void deleteJewellery(Integer jewelleryId);
}

