package com.example.springboot.DatabaseManagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

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

    // 6! = 720 permutations
    private List<String> generatedNames = PermutationsGenerator.generatePermutations("abcdef");

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

    private void populeazaBazaDeDate() {
        try {
            genereazaComenzi();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }

    private List<Farmacie> genereazaFarmacii() {
        List<Farmacie> farmacii = new ArrayList<>();

        for (int i = 0; i < generatedNames.size(); i++) {
            farmacii.add(new Farmacie(generatedNames.get(i)));
        }

        return farmacii;
    }

    private List<Categorie> genereazaCategorii() {
        List<Categorie> categorii = new ArrayList<>();

        categorii.add(new Categorie("Analgezice"));
        categorii.add(new Categorie("Anticoagulante"));
        categorii.add(new Categorie("Antiinflamatoare"));
        categorii.add(new Categorie("Antivirale"));
        categorii.add(new Categorie("Antibiotice"));
        categorii.add(new Categorie("Antidepresive"));
        categorii.add(new Categorie("Prokinetice"));
        categorii.add(new Categorie("Neuroleptice"));
        categorii.add(new Categorie("Probiotice"));
        categorii.add(new Categorie("Homeopatice"));
        categorii.add(new Categorie("Suplimente"));
        categorii.add(new Categorie("Naturiste"));

        return categorii;
    }

    private List<Medicament> genereazaMedicamente() {
        List<Medicament> medicamente = new ArrayList<>();

        List<Categorie> categorii = genereazaCategorii();
        repositoryCategorie.saveAll(categorii);

        for (int i = 0; i < generatedNames.size(); i++) {
            int stoc = getRandomNumber(100, 1000);
            int pret = getRandomNumber(5, 35);

            int lowerCategoryLimit = getRandomNumber(0, categorii.size() - 2);
            int upperCategoryLimit = getRandomNumber(lowerCategoryLimit + 1, categorii.size() - 1);

            medicamente.add(new Medicament(generatedNames.get(i), stoc, pret,
                    new HashSet<>(categorii.subList(lowerCategoryLimit, upperCategoryLimit))));
        }

        return medicamente;
    }

    private void genereazaComenzi() {
        List<Comanda> comenzi = new ArrayList<>();

        List<Farmacie> farmacii = genereazaFarmacii();
        repositoryFarmacie.saveAll(farmacii);

        List<Medicament> medicamente = genereazaMedicamente();
        repositoryMedicament.saveAll(medicamente);

        for (int i = 0; i < 1000; i++) {
            int indexFarmacie = getRandomNumber(0, farmacii.size() - 1);

            Comanda comanda = new Comanda(farmacii.get(indexFarmacie));
            comenzi.add(comanda);
        }

        repositoryComanda.saveAll(comenzi);
        genereazaMedicamenteComandate(comenzi, medicamente);
    }

    private void genereazaMedicamenteComandate(List<Comanda> comenzi, List<Medicament> medicamente) {
        List<MedicamentComandat> medicamenteComandate = new ArrayList<>();

        for (int i = 0; i < comenzi.size(); i++) {
            int numarElementeComandate = getRandomNumber(2, 10);
            for (int j = 0; j < numarElementeComandate; j++) {
                int cantitate = getRandomNumber(30, 150);
                int indexMedicament = getRandomNumber(0, medicamente.size() - 1);

                medicamenteComandate
                        .add(new MedicamentComandat(medicamente.get(indexMedicament), cantitate, comenzi.get(i)));
            }

        }

        repositoryMedicamentComandat.saveAll(medicamenteComandate);
    }

    private int getRandomNumber(int min, int max) {
        int randomNumber = (int) (Math.random() * (max - min + 1));
        if (randomNumber < 0) {
            randomNumber *= -1;
        }

        return randomNumber + min;
    }
}
