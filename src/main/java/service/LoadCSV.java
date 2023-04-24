package service;

import business.Notaire;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LoadCSV {
    public static List<Notaire> chargerNotairesDepuisCSV(String cheminFichier) throws IOException, CsvValidationException {
        List<Notaire> Notaires = new ArrayList<>();
        Reader reader = Files.newBufferedReader(Paths.get("listeNotaires.csv"));
        CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build(); // Ignorer la première ligne (en-têtes)
        String[] ligne;
        while ((ligne = csvReader.readNext()) != null) {
            //Titre;Nom;Prénom;Adresse;Résidence notariale;Email
            Notaire Notaire = new Notaire();
            Notaire.setTitre(ligne[0]);
            Notaire.setNom(ligne[1]);
            Notaire.setPrenom(ligne[2]);
            Notaire.setAdresse(ligne[3]);
            Notaire.setResidenceNotariale(ligne[4]);
            Notaire.setEmail(ligne[5]);
            Notaires.add(Notaire);
        }
        csvReader.close();
        return Notaires;
    }

}
