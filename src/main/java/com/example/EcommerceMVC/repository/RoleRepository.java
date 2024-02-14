package com.example.EcommerceMVC.repository;

import com.example.EcommerceMVC.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
