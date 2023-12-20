package fr.facil.facilapi.collections;

import com.mongodb.lang.Nullable;
import fr.facil.facilapi.supplement.Managers;
import fr.facil.facilapi.type.state_cmd;
import fr.facil.facilapi.type.type_cmd;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "Commande")
public class Commande {

    @Id
    private String id;
    private String numero;
    private Client client;
    private type_cmd type;
    private String date_debut;
    @Nullable
    private String date_fin_commande;

    private state_cmd state;
    private String documentContractuel;
    private String commandeClient;
    private String projet;
    private String centreDeCout;
    private String conditionGeneral;
    private String offre;
    private List<Relance> relanceList;
    private DocumentF doc;
    private double tj;
    private double quantite;

    private Managers managers;

    @Nullable
    private double sousTotal;
    @Nullable
    private double total;
    private boolean active;

    public Commande(String numero, Client client, type_cmd type, String date_debut, String date_fin_commande, state_cmd state, String documentContractuel, String commandeClient, String projet, String centreDeCout, String conditionGeneral, String offre, List<Relance> relanceList, DocumentF doc, double tj, double quantite, double sousTotal, double total, Managers managers,boolean active) {
        this.numero = numero;
        this.client = client;
        this.type = type;
        this.date_debut = date_debut;
        this.date_fin_commande = date_fin_commande;
        this.state = state;
        this.documentContractuel = documentContractuel;
        this.commandeClient = commandeClient;
        this.projet = projet;
        this.centreDeCout = centreDeCout;
        this.conditionGeneral = conditionGeneral;
        this.offre = offre;
        this.relanceList = relanceList;
        this.doc = doc;
        this.tj = tj;
        this.quantite = quantite;
        this.managers = managers;
        this.sousTotal = sousTotal;
        this.total = total;
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

    public type_cmd getType() {
        return type;
    }

    public void setType(type_cmd type) {
        this.type = type;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getDate_fin_commande() {
        return date_fin_commande;
    }

    public void setDate_fin_commande(String date_fin_commande) {
        this.date_fin_commande = date_fin_commande;
    }

    public state_cmd getState() {
        return state;
    }

    public void setState(state_cmd state) {
        this.state = state;
    }

    public String getDocumentContractuel() {
        return documentContractuel;
    }

    public void setDocumentContractuel(String documentContractuel) {
        this.documentContractuel = documentContractuel;
    }

    public String getCommandeClient() {
        return commandeClient;
    }

    public void setCommandeClient(String commandeClient) {
        this.commandeClient = commandeClient;
    }

    public String getProjet() {
        return projet;
    }

    public void setProjet(String projet) {
        this.projet = projet;
    }

    public String getCentreDeCout() {
        return centreDeCout;
    }

    public void setCentreDeCout(String centreDeCout) {
        this.centreDeCout = centreDeCout;
    }

    public String getConditionGeneral() {
        return conditionGeneral;
    }

    public void setConditionGeneral(String conditionGeneral) {
        this.conditionGeneral = conditionGeneral;
    }

    public String getOffre() {
        return offre;
    }

    public void setOffre(String offre) {
        this.offre = offre;
    }

    public List<Relance> getRelanceList() {
        return relanceList;
    }

    public void setRelanceList(List<Relance> relanceList) {
        this.relanceList = relanceList;
    }

    public DocumentF getDoc() {
        return doc;
    }

    public void setDoc(DocumentF doc) {
        this.doc = doc;
    }

    public double getTj() {
        return tj;
    }

    public void setTj(double tj) {
        this.tj = tj;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getSousTotal() {
        return sousTotal;
    }

    public void setSousTotal(double sousTotal) {
        this.sousTotal = sousTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Managers getManagers() {
        return managers;
    }

    public void setManagers(Managers managers) {
        this.managers = managers;
    }
}
