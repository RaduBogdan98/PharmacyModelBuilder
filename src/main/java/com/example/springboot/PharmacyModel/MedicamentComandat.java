package com.example.springboot.PharmacyModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.lang.NonNull;

@Entity
public class MedicamentComandat {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "idMedicament")
    private Medicament medicament;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "idComanda")
    private Comanda comanda; 

    private int cantitate;

    public MedicamentComandat(Medicament medicament, int cantitate, Comanda comanda){
        this.medicament = medicament;
        this.comanda = comanda;
        this.cantitate = cantitate;
    }
}
