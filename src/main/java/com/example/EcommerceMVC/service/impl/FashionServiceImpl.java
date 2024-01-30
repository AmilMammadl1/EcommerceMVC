package com.example.EcommerceMVC.service.impl;

import com.example.EcommerceMVC.dto.FashionDTO;
import com.example.EcommerceMVC.entity.Fashion;
import com.example.EcommerceMVC.repository.FashionRepository;
import com.example.EcommerceMVC.service.FashionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FashionServiceImpl implements FashionService {
    @Autowired
    private FashionRepository fashionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public FashionDTO createFashion(FashionDTO fashionDTO) {
        Fashion fashion = modelMapper.map(fashionDTO, Fashion.class);
        Fashion fashionCreated = fashionRepository.save(fashion);
        FashionDTO fashionDTOCreated = modelMapper.map(fashionCreated, FashionDTO.class);
        return fashionDTOCreated;
    }

    @Override
    public FashionDTO getFashionById(Integer fashionId) {
        Fashion fashion = fashionRepository.findById(fashionId).get();
        FashionDTO fashionDTO = modelMapper.map(fashion, FashionDTO.class);
        return fashionDTO;
    }

    @Override
    public List<FashionDTO> getAllFashion() {
        List<Fashion> fashionList = fashionRepository.findAll();
        List<FashionDTO> fashionDTOList = fashionList.stream()
                .map(fashion -> modelMapper.map(fashion, FashionDTO.class))
                .collect(Collectors.toList());
        return fashionDTOList;
    }

    @Override
    public FashionDTO updateFashion(FashionDTO fashionDTO) {
        Fashion fashion = fashionRepository.findById(fashionDTO.getId()).get();
        fashion.setFashionType(fashionDTO.getFashionType());
        fashion.setBrand(fashionDTO.getBrand());
        fashion.setDescription(fashionDTO.getDescription());
        fashion.setMaterial(fashionDTO.getMaterial());
        fashion.setColor(fashionDTO.getColor());
        fashion.setGender(fashionDTO.getGender());
        fashion.setPrice(fashionDTO.getPrice());
        fashion.setSize(fashionDTO.getSize());
        fashion.setImageURL(fashionDTO.getImageURL());

        Fashion fashionUpdated = fashionRepository.save(fashion);
        FashionDTO fashionDTOUpdated = modelMapper.map(fashionUpdated, FashionDTO.class);
        return fashionDTOUpdated;
    }

    @Override
    public void deleteFashion(Integer fashionId) {
        fashionRepository.deleteById(fashionId);

    }
}
