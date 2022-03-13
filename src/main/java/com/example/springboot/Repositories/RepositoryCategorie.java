package com.example.springboot.Repositories;

import com.example.springboot.PharmacyModel.Categorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCategorie extends JpaRepository<Categorie, Long> {

}
