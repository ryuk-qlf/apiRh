package fr.facil.facilapi.supplement.bl;

import lombok.Data;

@Data
public class tableRapport {

    private String details;
    private String prix_unitaire;
    private double nbe;
    private double prix;

    public tableRapport(String details, String prix_unitaire, double nbe, double prix) {
        this.details = details;
        this.prix_unitaire = prix_unitaire;
        this.nbe = nbe;
        this.prix = prix;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(String prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public double getNbe() {
        return nbe;
    }

    public void setNbe(double nbe) {
        this.nbe = nbe;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
