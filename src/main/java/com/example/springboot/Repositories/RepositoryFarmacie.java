package com.example.springboot.Repositories;

import com.example.springboot.PharmacyModel.Farmacie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryFarmacie extends JpaRepository<Farmacie, Long>{
    
}
