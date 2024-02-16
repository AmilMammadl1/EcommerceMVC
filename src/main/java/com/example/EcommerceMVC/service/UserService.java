package com.example.EcommerceMVC.service;

import com.example.EcommerceMVC.dto.UserDTO;
import com.example.EcommerceMVC.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);

    User findByUserByEmail(String email);

    List<UserDTO> findAllUser();
}
