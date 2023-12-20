package fr.facil.facilapi.supplement.bl;

import lombok.Data;

@Data
public class tableProduction {

    private String livrable;
    private String title;
    private String version;
    private String reference;
    private String date_livraison;
    private String prix_unitaire;
    private String acceptation;
    private String q;
    private String qtd;
    private String prix;

    public tableProduction(String livrable, String title, String version, String reference, String date_livraison, String prix_unitaire, String acceptation, String q, String qtd, String prix) {
        this.livrable = livrable;
        this.title = title;
        this.version = version;
        this.reference = reference;
        this.date_livraison = date_livraison;
        this.prix_unitaire = prix_unitaire;
        this.acceptation = acceptation;
        this.q = q;
        this.qtd = qtd;
        this.prix = prix;
    }

    public String getLivrable() {
        return livrable;
    }

    public void setLivrable(String livrable) {
        this.livrable = livrable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDate_livraison() {
        return date_livraison;
    }

    public void setDate_livraison(String date_livraison) {
        this.date_livraison = date_livraison;
    }

    public String getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(String prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public String getAcceptation() {
        return acceptation;
    }

    public void setAcceptation(String acceptation) {
        this.acceptation = acceptation;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getQtd() {
        return qtd;
    }

    public void setQtd(String qtd) {
        this.qtd = qtd;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }
}
