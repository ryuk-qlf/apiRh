package fr.facil.facilapi.collections;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.mongodb.lang.Nullable;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Log")
public class Log {

    @Id
    private String id;

    private String message;

    private String type;

    @JsonSerialize(using= ToStringSerializer.class)
    private ObjectId numeroAffaire;

    @Nullable
    private String numeroBl;

    private String date;

    @Nullable
    private DocumentF document;

    private boolean active;


    public Log(String message, String type, ObjectId numeroAffaire,@Nullable String numeroBl,String date,@Nullable DocumentF document, boolean active) {
        this.message = message;
        this.type = type;
        this.numeroAffaire = numeroAffaire;
        this.numeroBl = numeroBl;
        this.date = date;
        this.document = document;
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ObjectId getNumeroAffaire() {
        return numeroAffaire;
    }

    public void setNumeroAffaire(ObjectId numeroAffaire) {
        this.numeroAffaire = numeroAffaire;
    }

    @Nullable
    public String getNumeroBl() {
        return numeroBl;
    }

    public void setNumeroBl(String numeroBl) {
        this.numeroBl = numeroBl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Nullable
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
