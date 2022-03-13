package com.example.springboot.PharmacyModel;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.lang.NonNull;

@Entity
public class Comanda {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long idComanda;

    @NonNull
    private Date dataComenzii;

    @ManyToOne
    @JoinColumn(name = "idFarmacie")
    private Farmacie farmacie;

    @OneToMany
    private Set<MedicamentComandat> medicamentComandate;

    public Comanda (Farmacie farmacie){
        this.farmacie = farmacie;
        this.dataComenzii = new Date();
    }
}
