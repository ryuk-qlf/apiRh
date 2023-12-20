package fr.facil.facilapi.collections;


import fr.facil.facilapi.supplement.devisTable;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "Avoir")
public class Avoir {

    @Id
    private String id;

    private String num;
    private Facture facture;
    private Client client;
    private String dateCreated;
    private List<devisTable> table;
    private Commande commande;

    private double totalHt;
    private double total;

    private DocumentF document;
    private boolean active;

    public Avoir(String num, Facture facture, Client client, String dateCreated, List<devisTable> table, Commande commande, double totalHt, double total, DocumentF document, boolean active) {
        this.num = num;
        this.facture = facture;
        this.client = client;
        this.dateCreated = dateCreated;
        this.table = table;
        this.commande = commande;
        this.totalHt = totalHt;
        this.total = total;
        this.document = document;
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<devisTable> getTable() {
        return table;
    }

    public void setTable(List<devisTable> table) {
        this.table = table;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public double getTotalHt() {
        return totalHt;
    }

    public void setTotalHt(double totalHt) {
        this.totalHt = totalHt;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public DocumentF getDocument() {
        return document;
    }

    public void setDocument(DocumentF document) {
        this.document = document;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
