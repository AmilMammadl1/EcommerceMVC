package com.example.EcommerceMVC.security;

import com.example.EcommerceMVC.dto.UserDTO;
import com.example.EcommerceMVC.entity.User;
import com.example.EcommerceMVC.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User byEmail = userRepository.findByEmail(username);
        if(byEmail !=null){
            return new org.springframework.security.core.userdetails.User(byEmail.getEmail(),byEmail.getPassword(),
                    byEmail.getRoles().stream()
                            .map(role -> new SimpleGrantedAuthority(role.getName()))
                            .collect(Collectors.toList()));
        }
        else{
            throw new UsernameNotFoundException("password or username is invalid");
        }

    }
}
