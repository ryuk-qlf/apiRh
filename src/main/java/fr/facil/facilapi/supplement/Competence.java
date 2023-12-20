package fr.facil.facilapi.supplement;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Competence {

    String Libelle;

    public Competence(String libelle) {
        Libelle = libelle;
    }

    public String getLibelle() {
        return Libelle;
    }

    public void setLibelle(String libelle) {
        Libelle = libelle;
    }

}
