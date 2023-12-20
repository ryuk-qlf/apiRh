package fr.facil.facilapi.collections;

import fr.facil.facilapi.supplement.Managers;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Relance")
public class Relance {

    @Id
    private String id;

    private String title;

    private String message;

    private String dateCreated;

    private Managers send;

    private boolean isActive;

    public Relance(String title, String message, String dateCreated, Managers send, boolean isActive) {
        this.title = title;
        this.message = message;
        this.dateCreated = dateCreated;
        this.send = send;
        this.isActive = isActive;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Managers getSend() {
        return send;
    }

    public void setSend(Managers send) {
        this.send = send;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
