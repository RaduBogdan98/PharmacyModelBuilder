package com.example.springboot.PharmacyModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.lang.NonNull;

@Entity
public class MedicamentComandat {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NonNull
    @ManyToOne
    private Medicament medicament;

    @NonNull
    @ManyToOne
    private Comanda comanda; 

    private int cantitate;

    public MedicamentComandat(Medicament medicament, int cantitate, Comanda comanda){
        this.medicament = medicament;
        this.comanda = comanda;
        this.cantitate = cantitate;
    }
}
