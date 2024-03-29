package com.example.springboot.PharmacyModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long idCategorie;

    @NonNull
    private String nume;

    public Categorie(String nume){
        this.nume = nume;
    }

    public long getId() {
        return idCategorie;
    }

    public String getNume() {
        return nume;
    }
}
