package fr.facil.facilapi.collections;

import java.util.Date;

public class NoteDeFrais {

    private String typeNoteFrais;
    private int montantNoteDeFrais ;
    private Date dateNoteFrais ;
    private String prenom ;
    private String nom ;

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public NoteDeFrais(String typeNoteFrais, int montantNoteDeFrais, Date dateNoteFrais, String prenom, String nom) {
        this.typeNoteFrais = typeNoteFrais;
        this.montantNoteDeFrais = montantNoteDeFrais;
        this.dateNoteFrais = dateNoteFrais;
        this.prenom = prenom;
        this.nom = nom;
    }

    public String getTypeNoteFrais() {
        return typeNoteFrais;
    }

    public void setTypeNoteFrais(String typeNoteFrais) {
        this.typeNoteFrais = typeNoteFrais;
    }

    public int getMontantNoteDeFrais() {
        return montantNoteDeFrais;
    }

    public void setMontantNoteDeFrais(int montantNoteDeFrais) {
        this.montantNoteDeFrais = montantNoteDeFrais;
    }

    public Date getDateNoteFrais() {
        return dateNoteFrais;
    }

    public void setDateNoteFrais(Date dateNoteFrais) {
        this.dateNoteFrais = dateNoteFrais;
    }
}
