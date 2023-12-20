package fr.facil.facilapi.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Message")
public class Message {

    @Id
    private String id;
    private User emetter;
    private User receive;
    private String message;
    private boolean see;
    private String date;

    public Message(User emetter, User receive, String message,boolean see, String date) {
        this.emetter = emetter;
        this.receive = receive;
        this.message = message;
        this.see = see;
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getEmetter() {
        return emetter;
    }

    public void setEmetter(User emetter) {
        this.emetter = emetter;
    }

    public User getReceive() {
        return receive;
    }

    public void setReceive(User receive) {
        this.receive = receive;
    }

    public boolean isSee() {
        return see;
    }

    public void setSee(boolean see) {
        this.see = see;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
