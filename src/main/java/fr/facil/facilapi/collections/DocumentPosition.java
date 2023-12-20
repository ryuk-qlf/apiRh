package fr.facil.facilapi.collections;

import fr.facil.facilapi.supplement.document.position;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "documentPosition")
public class DocumentPosition {

    @Id
    private String id;

    private String type;

    private position position;

    private Client client;

    private boolean active;

    public DocumentPosition(String type, position position, Client client, boolean active) {
        this.type = type;
        this.position = position;
        this.client = client;
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public position getPosition() {
        return position;
    }

    public void setPosition(position position) {
        this.position = position;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
