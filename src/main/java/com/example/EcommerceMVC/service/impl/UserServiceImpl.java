package com.example.EcommerceMVC.service.impl;

import com.example.EcommerceMVC.dto.UserDTO;
import com.example.EcommerceMVC.entity.Role;
import com.example.EcommerceMVC.entity.User;
import com.example.EcommerceMVC.repository.RoleRepository;
import com.example.EcommerceMVC.repository.UserRepository;
import com.example.EcommerceMVC.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public void saveUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getFirstName()+" "+userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        Role role = roleRepository.findByName("ROLE_USER");
        if(role==null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }
    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_USER");
        return roleRepository.save(role);
    }

}
