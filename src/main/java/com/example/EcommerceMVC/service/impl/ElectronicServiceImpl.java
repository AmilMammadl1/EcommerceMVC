package com.example.EcommerceMVC.service.impl;

import com.example.EcommerceMVC.dto.ElectronicDTO;
import com.example.EcommerceMVC.entity.Electronic;
import com.example.EcommerceMVC.repository.ElectronicRepository;
import com.example.EcommerceMVC.service.ElectronicService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ElectronicServiceImpl implements ElectronicService {
    @Autowired
    private ElectronicRepository electronicRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ElectronicDTO createElectronic(ElectronicDTO electronicDTO) {
        Electronic electronic = modelMapper.map(electronicDTO, Electronic.class);
        Electronic electronicCreated = electronicRepository.save(electronic);
        ElectronicDTO electronicDtoCreated = modelMapper.map(electronicCreated, ElectronicDTO.class);
        return electronicDtoCreated;
    }

    @Override
    public ElectronicDTO getElectronicById(Integer electronicId) {
        Electronic electronic = electronicRepository.findById(electronicId).get();
        ElectronicDTO electronicDTO = modelMapper.map(electronic, ElectronicDTO.class);
        return electronicDTO;
    }

    @Override
    public List<ElectronicDTO> getAllElectronic() {
        List<Electronic> allElectronic = electronicRepository.findAll();
        List<ElectronicDTO> allElectronicDto = allElectronic.stream()
                .map(electronic -> modelMapper.map(electronic, ElectronicDTO.class))
                .collect(Collectors.toList());

        return allElectronicDto;
    }
    @Override
    public ElectronicDTO updateElectronic(ElectronicDTO electronicDTO) {
        Electronic electronic = modelMapper.map(electronicDTO, Electronic.class);
        Optional<Electronic> electronicOptional = electronicRepository.findById(electronic.getId());

        if (electronicOptional.isPresent()) {
            Electronic electronicExisting = electronicOptional.get();
            electronicExisting.setElectronicType(electronicDTO.getElectronicType());
            electronicExisting.setDescription(electronicDTO.getDescription());
            electronicExisting.setBrand(electronicDTO.getBrand());
            electronicExisting.setPrice(electronicDTO.getPrice());
            electronicExisting.setModel(electronicDTO.getModel());
            electronicExisting.setRamSizeGB(electronicDTO.getRamSizeGB());
            electronicExisting.setScreenSizeInch(electronicDTO.getScreenSizeInch());
            electronicExisting.setStorageCapacityGB(electronicDTO.getStorageCapacityGB());
            electronicExisting.setImageURL(electronicDTO.getImageURL());

            Electronic electronicSaved = electronicRepository.save(electronicExisting);
            ElectronicDTO electronicDTOSaved = modelMapper.map(electronicSaved, ElectronicDTO.class);

            return electronicDTOSaved;
        } else {
            // Handle the case where Electronic with given ID doesn't exist
            // You can throw an exception, log an error, or return a specific response
            throw new NoSuchElementException("Electronic with ID " + electronicDTO.getId() + " not found");
        }
    }

    @Override
    public void deleteElectronic(Integer electronicId) {
        electronicRepository.deleteById(electronicId);
    }
}
