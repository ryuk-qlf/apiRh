package fr.facil.facilapi.collections;

import com.mongodb.lang.Nullable;
import fr.facil.facilapi.supplement.devisTable;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "Devis")
public class Devis {

    @Id
    private String id;

    private String num;
    private String dateCreated;
    private String dateEcheance;

    private Client client;

    @Nullable
    private Affaire affaire;

    private List<devisTable> table;
    private double totalHt;
    private double total;

    private DocumentF doc;
    private boolean signed;

    private boolean active;


    public Devis(String num, String dateCreated, String dateEcheance, Client client, @Nullable Affaire affaire, List<devisTable> table, double totalHt, double total, DocumentF doc, boolean signed, boolean active) {
        this.num = num;
        this.dateCreated = dateCreated;
        this.dateEcheance = dateEcheance;
        this.client = client;
        this.affaire = affaire;
        this.table = table;
        this.totalHt = totalHt;
        this.total = total;
        this.doc = doc;
        this.signed = signed;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<devisTable> getTable() {
        return table;
    }

    public void setTable(List<devisTable> table) {
        this.table = table;
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

    public DocumentF getDoc() {
        return doc;
    }

    public void setDoc(DocumentF doc) {
        this.doc = doc;
    }

    public boolean isSigned() {
        return signed;
    }

    public void setSigned(boolean signed) {
        this.signed = signed;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Nullable
    public Affaire getAffaire() {
        return affaire;
    }

    public void setAffaire(@Nullable Affaire affaire) {
        this.affaire = affaire;
    }
}
