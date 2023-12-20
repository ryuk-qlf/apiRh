package fr.facil.facilapi.supplement;

public class UserPhoto {

    private String nom;
    private String content;

    private String path ;
    private String type ;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserPhoto(String nom, String content, String path, String type) {
        this.nom = nom;
        this.content = content;
        this.path = path;
        this.type = type;
    }
}
