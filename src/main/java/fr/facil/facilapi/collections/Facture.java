package fr.facil.facilapi.collections;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.mongodb.lang.Nullable;
import fr.facil.facilapi.supplement.devisTable;
import fr.facil.facilapi.type.paiement;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document( collection = "Facture")
public class Facture {

    @Id
    private String id;
    private String numero;

    @Nullable
    private BL bl;

    private paiement paiement;

    @JsonSerialize(using= ToStringSerializer.class)
    private ObjectId affaire;

    private Commande commande;

    private double montant;

    private List<Log> logs;

    private List<Relance> relanceList;

    private List<devisTable> table;

    private DocumentF document;

    private String dateCreated;

    private String dateEcheance;

    private boolean active;

    public Facture(String numero, @Nullable BL bl, fr.facil.facilapi.type.paiement paiement, ObjectId affaire, Commande commande, double montant, List<Log> logs, List<Relance> relanceList, List<devisTable> table, DocumentF document, String dateCreated, String dateEcheance, boolean active) {
        this.numero = numero;
        this.bl = bl;
        this.paiement = paiement;
        this.affaire = affaire;
        this.commande = commande;
        this.montant = montant;
        this.logs = logs;
        this.relanceList = relanceList;
        this.table = table;
        this.document = document;
        this.dateCreated = dateCreated;
        this.dateEcheance = dateEcheance;
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Nullable
    public BL getBl() {
        return bl;
    }

    public void setBl(BL bl) {
        this.bl = bl;
    }

    public fr.facil.facilapi.type.paiement getPaiement() {
        return paiement;
    }

    public void setPaiement(fr.facil.facilapi.type.paiement paiement) {
        this.paiement = paiement;
    }

    public boolean isActive() {return active;}

    public void setActive(boolean active) {this.active = active;}

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public List<Log> getLogs() {
        return logs;
    }

    public void setLogs(List<Log> logs) {
        this.logs = logs;
    }

    public ObjectId getAffaire() {
        return affaire;
    }

    public void setAffaire(ObjectId affaire) {
        this.affaire = affaire;
    }

    public List<Relance> getRelanceList() {
        return relanceList;
    }

    public void setRelanceList(List<Relance> relanceList) {
        this.relanceList = relanceList;
    }

    public DocumentF getDocument() {
        return document;
    }

    public void setDocument(DocumentF document) {
        this.document = document;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateEcheance() {
        return dateEcheance;
    }

    public void setDateEcheance(String dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public List<devisTable> getTable() {
        return table;
    }

    public void setTable(List<devisTable> table) {
        this.table = table;
    }
}
