package com.example.springboot.Repositories;

import com.example.springboot.PharmacyModel.Comanda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryComanda extends JpaRepository<Comanda, Long> {

}
