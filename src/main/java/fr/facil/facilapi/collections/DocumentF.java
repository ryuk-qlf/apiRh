package fr.facil.facilapi.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Document")
public class DocumentF {

    @Id
    private String id;

    private String title;

    private String type;

    private String content;

    private String atCreated;

    private boolean active;

    public DocumentF(String id, String title, String type, String content, String atCreated, boolean active) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.content = content;
        this.atCreated = atCreated;
        this.active = active;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAtCreated() {
        return atCreated;
    }

    public void setAtCreated(String atCreated) {
        this.atCreated = atCreated;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
