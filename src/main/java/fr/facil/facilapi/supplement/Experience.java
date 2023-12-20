package fr.facil.facilapi.supplement;

import lombok.Data;

@Data
public class Experience {

    /*

    - titre
    - description du poste
    - nom de l'entreprise
    - date début
    - date fin

     */

    String titre;
    String description;
    String nom_entreprise;
    String date_debut;
    String date_fin;

    public Experience(String titre, String description, String nom_entreprise, String date_debut, String date_fin) {
        this.titre = titre;
        this.description = description;
        this.nom_entreprise = nom_entreprise;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom_entreprise() {
        return nom_entreprise;
    }

    public void setNom_entreprise(String nom_entreprise) {
        this.nom_entreprise = nom_entreprise;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }
}
