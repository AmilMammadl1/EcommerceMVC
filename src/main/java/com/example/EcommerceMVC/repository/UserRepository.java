package com.example.EcommerceMVC.repository;

import com.example.EcommerceMVC.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
