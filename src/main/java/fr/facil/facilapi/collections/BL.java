package fr.facil.facilapi.collections;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import fr.facil.facilapi.supplement.bl.tableProduction;
import fr.facil.facilapi.supplement.bl.tableRapport;
import fr.facil.facilapi.supplement.devisTable;
import fr.facil.facilapi.type.State_bl;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "BL")
public class BL {

    @Id
    private String id;
    private String num;
    private String date_bl;

    private String dateEnd;

    @JsonSerialize(using= ToStringSerializer.class)
    private ObjectId affaire;

    private String date_reglement;
    private State_bl etat;
    private boolean comeFacture;

    private DocumentF doc;

    private List<tableProduction> production;

    private List<tableRapport> rapport;

    private List<Log> logs;

    private List<Relance> relanceList;
    private boolean active;

    public BL(String id, String num, String date_bl, String dateEnd, ObjectId affaire, String date_reglement, State_bl etat, boolean comeFacture, DocumentF doc, List<tableProduction> production, List<tableRapport> rapport, List<Log> logs, List<Relance> relanceList, boolean active) {
        this.id = id;
        this.num = num;
        this.date_bl = date_bl;
        this.dateEnd = dateEnd;
        this.affaire = affaire;
        this.date_reglement = date_reglement;
        this.etat = etat;
        this.comeFacture = comeFacture;
        this.doc = doc;
        this.production = production;
        this.rapport = rapport;
        this.logs = logs;
        this.relanceList = relanceList;
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getDate_bl() {
        return date_bl;
    }

    public void setDate_bl(String date_bl) {
        this.date_bl = date_bl;
    }

    public String getDate_reglement() {
        return date_reglement;
    }

    public void setDate_reglement(String date_reglement) {
        this.date_reglement = date_reglement;
    }

    public State_bl getEtat() {
        return etat;
    }

    public void setEtat(State_bl etat) {
        this.etat = etat;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    public boolean getComeFacture() {
        return comeFacture;
    }

    public void setComeFacture(boolean comeFacture) {
        this.comeFacture = comeFacture;
    }


    public boolean isComeFacture() {
        return comeFacture;
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

    public List<Relance> getRelanceList() {return relanceList;}

    public void setRelanceList(List<Relance> relanceList) {this.relanceList = relanceList;
    }

    public DocumentF getDoc() {
        return doc;
    }

    public void setDoc(DocumentF doc) {
        this.doc = doc;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public List<tableProduction> getProduction() {
        return production;
    }

    public void setProduction(List<tableProduction> production) {
        this.production = production;
    }

    public List<tableRapport> getRapport() {
        return rapport;
    }

    public void setRapport(List<tableRapport> rapport) {
        this.rapport = rapport;
    }
}
