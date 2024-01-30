package com.example.EcommerceMVC.service.impl;

import com.example.EcommerceMVC.dto.JewelleryDTO;
import com.example.EcommerceMVC.entity.Jewellery;
import com.example.EcommerceMVC.repository.FashionRepository;
import com.example.EcommerceMVC.repository.JewelleryRepository;
import com.example.EcommerceMVC.service.JewelleryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JewelleryServiceImpl implements JewelleryService {
    @Autowired
    private JewelleryRepository jewelleryRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public JewelleryDTO createJewellery(JewelleryDTO jewelleryDTO) {
        Jewellery jewellery = modelMapper.map(jewelleryDTO, Jewellery.class);
        Jewellery jewelleryCreated = jewelleryRepository.save(jewellery);
        JewelleryDTO jewelleryDTOCreated = modelMapper.map(jewelleryCreated, JewelleryDTO.class);
        return jewelleryDTOCreated;
    }

    @Override
    public JewelleryDTO getJewelleryById(Integer jewelleryId) {
        Jewellery jewellery = jewelleryRepository.findById(jewelleryId).get();
        JewelleryDTO jewelleryDTO = modelMapper.map(jewellery, JewelleryDTO.class);

        return jewelleryDTO;
    }

    @Override
    public List<JewelleryDTO> getAllJewellery() {
        List<Jewellery> jewelleryList = jewelleryRepository.findAll();
        List<JewelleryDTO> jewelleryDTOList = jewelleryList.stream()
                .map(jewellery -> modelMapper.map(jewellery, JewelleryDTO.class))
                .collect(Collectors.toList());

        return jewelleryDTOList;
    }

    @Override
    public JewelleryDTO updateJewellery(JewelleryDTO jewelleryDTO) {
        Jewellery jewellery = jewelleryRepository.findById(jewelleryDTO.getId()).get();
        jewellery.setBrand(jewelleryDTO.getBrand());
        jewellery.setJewelleryType(jewelleryDTO.getJewelleryType());
        jewellery.setMaterial(jewelleryDTO.getMaterial());
        jewellery.setDescription(jewelleryDTO.getDescription());
        jewellery.setPrice(jewelleryDTO.getPrice());
        jewellery.setImageURL(jewellery.getImageURL());

        Jewellery jewelleryUpdated = jewelleryRepository.save(jewellery);
        JewelleryDTO jewelleryDTOUpdated = modelMapper.map(jewelleryUpdated, JewelleryDTO.class);

        return jewelleryDTOUpdated;

    }

    @Override
    public void deleteJewellery(Integer jewelleryId) {
        jewelleryRepository.deleteById(jewelleryId);

    }
}
