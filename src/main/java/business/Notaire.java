package business;

import java.util.ArrayList;
import java.util.List;

public class Notaire {

    private String titre;
    private String nom;
    private String prenom;
    private String adresse;
    private String residenceNotariale;
    private String email;
    private String nomUtilisateur;
    private String motDePasse;

    public Notaire(String titre, String nom, String prenom, String adresse, String residenceNotariale, String email, String nomUtilisateur, String motDePasse) {
        this.titre = titre;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.residenceNotariale = residenceNotariale;
        this.email = email;
        this.nomUtilisateur = nomUtilisateur;
        this.motDePasse = motDePasse;

    }

    public Notaire() {
    }

    // Getters and Setters
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getResidenceNotariale() {
        return residenceNotariale;
    }

    public void setResidenceNotariale(String residenceNotariale) {
        this.residenceNotariale = residenceNotariale;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public List<Notaire> rechercherNotaire(List<Notaire> notaires, String recherche) {
        List<Notaire> resultats = new ArrayList<>();
        for (Notaire notaire : notaires) {
            if (notaire.getNom().contains(recherche) || notaire.getPrenom().contains(recherche) ||
                    notaire.getAdresse().contains(recherche) || notaire.getResidenceNotariale().contains(recherche) ||
                    notaire.getEmail().contains(recherche)) {
                resultats.add(notaire);
            }
        }
        return resultats;
    }

    public Notaire authentifierNotaire(List<Notaire> notaires, String nomUtilisateur, String motDePasse) {
        for (Notaire notaire : notaires) {
            if (notaire.getNomUtilisateur().equalsIgnoreCase(nomUtilisateur) && notaire.getMotDePasse().equalsIgnoreCase(motDePasse)) {
                return notaire;
            }
        }
        return null; // Les identifiants sont incorrects
    }


}
