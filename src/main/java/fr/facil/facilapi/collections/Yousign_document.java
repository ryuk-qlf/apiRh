package fr.facil.facilapi.collections;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "Yousign_document")
public class Yousign_document {

    @Id
    private String id;

    private String type;

    @JsonSerialize(using= ToStringSerializer.class)
    private ObjectId num;

    private List<String> id_fileobject;

    private String id_procedures;

    private String id_file;

    private List<String> id_member;

    private String comment;

    private boolean active;

    public Yousign_document(String type, ObjectId num, List<String> id_fileobject, String id_procedures,
                            String id_file, List<String> id_member, String comment, boolean active) {
        this.type = type;
        this.num = num;
        this.id_fileobject = id_fileobject;
        this.id_procedures = id_procedures;
        this.id_file = id_file;
        this.id_member = id_member;
        this.comment = comment;
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getId_fileobject() {
        return id_fileobject;
    }

    public void setId_fileobject(List<String> id_fileobject) {
        this.id_fileobject = id_fileobject;
    }

    public String getId_procedures() {
        return id_procedures;
    }

    public void setId_procedures(String id_procedures) {
        this.id_procedures = id_procedures;
    }

    public String getId_file() {
        return id_file;
    }

    public void setId_file(String id_file) {
        this.id_file = id_file;
    }

    public List<String> getId_member() {
        return id_member;
    }

    public void setId_member(List<String> id_member) {
        this.id_member = id_member;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ObjectId getNum() {
        return num;
    }

    public void setNum(ObjectId num) {
        this.num = num;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
