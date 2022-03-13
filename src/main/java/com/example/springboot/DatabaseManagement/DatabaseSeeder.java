package com.example.springboot.DatabaseManagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import com.example.springboot.PharmacyModel.Categorie;
import com.example.springboot.PharmacyModel.Comanda;
import com.example.springboot.PharmacyModel.Farmacie;
import com.example.springboot.PharmacyModel.Medicament;
import com.example.springboot.PharmacyModel.MedicamentComandat;
import com.example.springboot.Repositories.RepositoryCategorie;
import com.example.springboot.Repositories.RepositoryComanda;
import com.example.springboot.Repositories.RepositoryFarmacie;
import com.example.springboot.Repositories.RepositoryMedicament;
import com.example.springboot.Repositories.RepositoryMedicamentComandat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private RepositoryFarmacie repositoryFarmacie;
    private RepositoryComanda repositoryComanda;
    private RepositoryCategorie repositoryCategorie;
    private RepositoryMedicament repositoryMedicament;
    private RepositoryMedicamentComandat repositoryMedicamentComandat;

    @Autowired
    public DatabaseSeeder(
            RepositoryFarmacie repositoryFarmacie,
            RepositoryComanda repositoryComanda,
            RepositoryCategorie repositoryCategorie,
            RepositoryMedicament repositoryMedicament,
            RepositoryMedicamentComandat repositoryMedicamentComandat) {

        this.repositoryFarmacie = repositoryFarmacie;
        this.repositoryCategorie = repositoryCategorie;
        this.repositoryComanda = repositoryComanda;
        this.repositoryMedicament = repositoryMedicament;
        this.repositoryMedicamentComandat = repositoryMedicamentComandat;
    }

    @Override
    public void run(String... args) throws Exception {
        populeazaBazaDeDate();
    }

    private void populeazaBazaDeDate(){
        try{
            Farmacie farmacie = new Farmacie("Dr. Max");

            Categorie analgezice = new Categorie("Analgezice");
            Categorie antibiotice = new Categorie("Antibiotice");
            Categorie calmante = new Categorie("Calmante");
            ArrayList<Categorie> categorii = new ArrayList<>();
            categorii.add(analgezice);
            categorii.add(antibiotice);
            categorii.add(calmante);
    
            Medicament algocalmin = new Medicament("Algocalmin", 100, 12, new HashSet<>(Arrays.asList(calmante)));
            Medicament nurofen = new Medicament("Nurofen", 100, 14, new HashSet<>(Arrays.asList(calmante, antibiotice)));
            Medicament analgezic = new Medicament("Medicament Analgezic", 100, 16, new HashSet<>(Arrays.asList(analgezice)));
            ArrayList<Medicament> medicamente = new ArrayList<>();
            medicamente.add(algocalmin);
            medicamente.add(nurofen);
            medicamente.add(analgezic);

            Comanda comandaDrMax = new Comanda(farmacie);

            HashSet<MedicamentComandat> medicamentComandate = new HashSet<>(
                Arrays.asList(
                    new MedicamentComandat(algocalmin, 10, comandaDrMax),
                    new MedicamentComandat(nurofen, 15, comandaDrMax)
                )
            );
    
            repositoryFarmacie.save(farmacie);
            repositoryCategorie.saveAll(categorii);
            repositoryMedicament.saveAll(medicamente);
            repositoryComanda.save(comandaDrMax);
            repositoryMedicamentComandat.saveAll(medicamentComandate);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }   
    }
}
