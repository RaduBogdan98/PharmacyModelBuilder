package com.example.springboot.PharmacyModel;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.lang.NonNull;

@Entity
public class Medicament {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long idMedicament;

    @NonNull
    private String nume;
    private int stoc;
    private int pret;

    @ManyToMany
    private Set<Categorie> categorii;

    public Medicament(String nume, int stoc, int pret, Set<Categorie> categorii) {
        this.nume = nume;
        this.stoc = stoc;
        this.pret = pret;
        this.categorii = categorii;
    }
}
