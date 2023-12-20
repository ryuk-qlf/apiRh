package fr.facil.facilapi.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "JourTravail")
public class jourTravail {


    @Id
    private Integer id;

    private Ressource_Humaine rs;

    private String libelle;

    private int mois;

    private List<Ressource_Humaine> rh;

    private int annees;

    private int nombre;
    private boolean presenceMatin ;
    private boolean presenceApresMidi ;

    public jourTravail(Integer id, Ressource_Humaine rs, String libelle, int mois, List<Ressource_Humaine> rh, int annees, int nombre, boolean presenceMatin, boolean presenceApresMidi) {
        this.id = id;
        this.rs = rs;
        this.libelle = libelle;
        this.mois = mois;
        this.rh = rh;
        this.annees = annees;
        this.nombre = nombre;
        this.presenceMatin = presenceMatin;
        this.presenceApresMidi = presenceApresMidi;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ressource_Humaine getRs() {
        return rs;
    }

    public void setRs(Ressource_Humaine rs) {
        this.rs = rs;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getAnnees() {
        return annees;
    }

    public void setAnnees(int annees) {
        this.annees = annees;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public boolean isPresenceMatin() {
        return this.presenceMatin;
    }

    public void setPresenceMatin(boolean presenceMatin) {
        this.presenceMatin = presenceMatin;
    }

    public boolean isPresenceApresMidi() {
        return this.presenceApresMidi;
    }

    public void setPresenceApresMidi(boolean presenceApresMidi) {
        this.presenceApresMidi = presenceApresMidi;
    }

}
