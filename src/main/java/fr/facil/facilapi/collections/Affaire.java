package fr.facil.facilapi.collections;

import fr.facil.facilapi.supplement.Managers;
import fr.facil.facilapi.supplement.Ndf;
import fr.facil.facilapi.supplement.Status;
import fr.facil.facilapi.supplement.rAchat;
import fr.facil.facilapi.type.tva;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "Affaire")
public class Affaire {


    @Id
    private String id;
    private List<Ressource_Humaine> rh;
    private Client client;

    private List<Ndf> ndf;
    private List<Commande> cmds;
    private String reference;
    private String date_debut;

    private Date date_prevu;

    private String date_fin;
    private String libelle;
    private String date_creation;
    private Managers managers;

    private rAchat achat;
    private List<Relance> relance;
    private List<BL> blList;
    private List<Facture> factureList;
    private List<Avoir> avoirList;
    private List<Devis> devisList;
    private List<Note> noteList;

    private Status status;

    private boolean active;

    public Affaire(String id, List<Ressource_Humaine> rh, Client client, List<Ndf> ndf, List<Commande> cmds,
                   String reference, String date_debut, Date date_prevu ,String date_fin, String libelle, String date_creation,
                   Managers managers, rAchat achat, List<Relance> relance, List<BL> blList, List<Facture> factureList,
                   List<Avoir> avoirList, List<Devis> devisList,List<Note> noteList, Status status,boolean active) {
        this.id = id;
        this.rh = rh;
        this.client = client;
        this.ndf = ndf;
        this.cmds = cmds;
        this.reference = reference;
        this.date_debut = date_debut;

        this.date_prevu = date_prevu;

        this.date_fin = date_fin;
        this.libelle = libelle;
        this.date_creation = date_creation;
        this.managers = managers;
        this.achat = achat;
        this.relance = relance;
        this.blList = blList;
        this.factureList = factureList;
        this.avoirList = avoirList;
        this.devisList = devisList;
        this.noteList = noteList;
        this.status = status;
        this.active = active;
    }



    public Client getClient() {
        return client;
    }

    public void setClient( Client client) {
        this.client = client;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Ressource_Humaine> getRh() {
        return rh;
    }

    public void setRh(List<Ressource_Humaine> rh) {
        this.rh = rh;
    }

    public List<Ndf> getNdf() {
        return ndf;
    }

    public void setNdf(List<Ndf> ndf) {
        this.ndf = ndf;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
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

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Commande> getCmds() {
        return cmds;
    }

    public void setCmds(List<Commande> cmds) {
        this.cmds = cmds;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Managers getManagers() {
        return managers;
    }

    public void setManagers(Managers managers) {
        this.managers = managers;
    }

    public List<Relance> getRelance() {
        return relance;
    }

    public void setRelance(List<Relance> relance) {
        this.relance = relance;
    }

    public List<BL> getBlList() {
        return blList;
    }

    public void setBlList(List<BL> blList) {
        this.blList = blList;
    }

    public List<Facture> getFactureList() {
        return factureList;
    }

    public void setFactureList(List<Facture> factureList) {
        this.factureList = factureList;
    }

    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }

    public rAchat getAchat() {
        return achat;
    }

    public void setAchat(rAchat achat) {
        this.achat = achat;
    }

    public List<Avoir> getAvoirList() {
        return avoirList;
    }

    public void setAvoirList(List<Avoir> avoirList) {
        this.avoirList = avoirList;
    }

    public List<Devis> getDevisList() {
        return devisList;
    }

    public void setDevisList(List<Devis> devisList) {
        this.devisList = devisList;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getDate_prevu() {
        return date_prevu;
    }

    public void setDate_prevu(Date date_prevu) {
        this.date_prevu = date_prevu;
    }
}
