package fr.facil.facilapi.supplement;

import lombok.Data;

@Data
public class Comment {

    private String comment;

    public Comment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
