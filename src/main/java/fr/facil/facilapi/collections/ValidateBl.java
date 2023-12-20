package fr.facil.facilapi.collections;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "ValidateBl")
public class ValidateBl {

    @Id
    private String id;

    @JsonSerialize(using= ToStringSerializer.class)
    private ObjectId bl;

    @JsonSerialize(using= ToStringSerializer.class)
    private ObjectId affaire;

    @JsonSerialize(using= ToStringSerializer.class)
    private ObjectId commande;

    private String dateCreated;

    private String status;

    private boolean active;


    public ValidateBl(ObjectId bl, ObjectId affaire, ObjectId commande, String dateCreated, String status, boolean active) {
        this.bl = bl;
        this.affaire = affaire;
        this.commande = commande;
        this.dateCreated = dateCreated;
        this.status = status;
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ObjectId getBl() {
        return bl;
    }

    public void setBl(ObjectId bl) {
        this.bl = bl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public ObjectId getAffaire() {
        return affaire;
    }

    public void setAffaire(ObjectId affaire) {
        this.affaire = affaire;
    }

    public ObjectId getCommande() {
        return commande;
    }

    public void setCommande(ObjectId commande) {
        this.commande = commande;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
}
