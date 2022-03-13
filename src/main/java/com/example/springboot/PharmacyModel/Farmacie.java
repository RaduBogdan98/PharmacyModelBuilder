package com.example.springboot.PharmacyModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

@Entity
public class Farmacie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long idFarmacie;

    @NonNull
    private String nume;

    public Farmacie(String nume){
        this.nume = nume;
    }
}
