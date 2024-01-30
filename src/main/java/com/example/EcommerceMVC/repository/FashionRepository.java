package com.example.EcommerceMVC.repository;

import com.example.EcommerceMVC.entity.Electronic;
import com.example.EcommerceMVC.entity.Fashion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FashionRepository extends JpaRepository<Fashion,Integer> {
}
