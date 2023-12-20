package fr.facil.facilapi.supplement;

import lombok.Data;

@Data
public class rAchat {

    private String nom;

    private String prenom;

    private String email;

    private String mobilePhone;

    private boolean active;

    public rAchat(String nom, String prenom, String email, String mobilePhone, boolean active) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mobilePhone = mobilePhone;
        this.active = active;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
