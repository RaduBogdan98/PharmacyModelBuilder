package com.example.springboot.Repositories;

import com.example.springboot.PharmacyModel.MedicamentComandat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryMedicamentComandat extends JpaRepository<MedicamentComandat, Long>{
    
}
