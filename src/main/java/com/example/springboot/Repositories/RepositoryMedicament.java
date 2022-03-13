package com.example.springboot.Repositories;

import com.example.springboot.PharmacyModel.Medicament;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryMedicament extends JpaRepository<Medicament, Long> {

}
