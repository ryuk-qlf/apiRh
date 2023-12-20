package fr.facil.facilapi.supplement;

import lombok.Data;

@Data
public class Indemnite {

    private String libelle;
    private double prix;

    public Indemnite(String libelle, double prix) {
        this.libelle = libelle;
        this.prix = prix;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
