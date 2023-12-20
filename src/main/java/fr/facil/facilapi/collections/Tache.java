package fr.facil.facilapi.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Tache")
public class Tache {

    @Id
    private String id;

    private String DateDebut;
    private String DateFin;
    private String LibTache;
    private int EtatTache;
    private String ContenuTache;
    private Boolean JourEntier;

    private Ressource_Humaine rh;
    private TypeTache type;
    private LieuTache lieu;

    public Tache(String dateDebut, String dateFin, String libTache, int etatTache, String contenuTache, Boolean jourEntier, Ressource_Humaine rh, TypeTache type, LieuTache lieu) {
        DateDebut = dateDebut;
        DateFin = dateFin;
        LibTache = libTache;
        EtatTache = etatTache;
        ContenuTache = contenuTache;
        JourEntier = jourEntier;
        this.rh = rh;
        this.type = type;
        this.lieu = lieu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateDebut() {
        return DateDebut;
    }

    public void setDateDebut(String dateDebut) {
        DateDebut = dateDebut;
    }

    public String getDateFin() {
        return DateFin;
    }

    public void setDateFin(String dateFin) {
        DateFin = dateFin;
    }

    public String getLibTache() {
        return LibTache;
    }

    public void setLibTache(String libTache) {
        LibTache = libTache;
    }

    public int getEtatTache() {
        return EtatTache;
    }

    public void setEtatTache(int etatTache) {
        EtatTache = etatTache;
    }

    public String getContenuTache() {
        return ContenuTache;
    }

    public void setContenuTache(String contenuTache) {
        ContenuTache = contenuTache;
    }

    public Boolean getJourEntier() {
        return JourEntier;
    }

    public void setJourEntier(Boolean jourEntier) {
        JourEntier = jourEntier;
    }

    public Ressource_Humaine getRh() {
        return rh;
    }

    public void setRh(Ressource_Humaine rh) {
        this.rh = rh;
    }

    public TypeTache getType() {
        return type;
    }

    public void setType(TypeTache type) {
        this.type = type;
    }

    public LieuTache getLieu() {
        return lieu;
    }

    public void setLieu(LieuTache lieu) {
        this.lieu = lieu;
    }
}
