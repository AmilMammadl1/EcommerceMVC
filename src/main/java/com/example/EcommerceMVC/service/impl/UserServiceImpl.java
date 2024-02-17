package com.example.EcommerceMVC.service.impl;

import com.example.EcommerceMVC.dto.UserDTO;
import com.example.EcommerceMVC.entity.Role;
import com.example.EcommerceMVC.entity.User;
import com.example.EcommerceMVC.repository.RoleRepository;
import com.example.EcommerceMVC.repository.UserRepository;
import com.example.EcommerceMVC.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public void saveUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getFirstName()+" "+userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        Role role = roleRepository.findByName("ROLE_USER");
        if(role==null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public User findByUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDTO> findAllUser() {
        List<User> all = userRepository.findAll();
        return all.stream()
                .map(user -> mapToUserDto(user))
                .collect(Collectors.toList());

    }
    private UserDTO mapToUserDto(User user){
        UserDTO userDTO = new UserDTO();
        String[] s = user.getName().split(" ");
        userDTO.setFirstName(s[0]);
        userDTO.setLastName(s[1]);
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }


    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_USER");
        return roleRepository.save(role);
    }

}
