package fr.facil.facilapi.supplement;

import lombok.Data;

@Data
public class Formation {

    /*

    - Nom ecole
    - Titre diplome / habilitation
    - date debut
    - date fin

     */

    String Nom_ecole;
    String Titre;
    String date_debut;
    String date_fin;

    public Formation(String nom_ecole, String titre, String date_debut, String date_fin) {
        Nom_ecole = nom_ecole;
        Titre = titre;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public String getNom_ecole() {
        return Nom_ecole;
    }

    public void setNom_ecole(String nom_ecole) {
        Nom_ecole = nom_ecole;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
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
