package fr.facil.facilapi.collections;

import lombok.Data;

@Data
public class Note {

    private int number;

    private String author;

    private String message;

    private String createdAt;

    private String modifyAt;

    private boolean active;


    public Note(int number, String author, String message, String createdAt, String modifyAt, boolean active) {
        this.number = number;
        this.author = author;
        this.message = message;
        this.createdAt = createdAt;
        this.modifyAt = modifyAt;
        this.active = active;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getModifyAt() {
        return modifyAt;
    }

    public void setModifyAt(String modifyAt) {
        this.modifyAt = modifyAt;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
