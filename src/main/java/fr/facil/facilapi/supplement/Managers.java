package fr.facil.facilapi.supplement;

import lombok.Data;

@Data
public class Managers {

    private String nom;
    private String prenom;
    private String mobilePhone;
    private String email;
    private String dependence;
    private String departement;
    private boolean active;

    public Managers(String nom, String prenom, String mobilePhone, String email, String dependence, String departement, boolean active) {
        this.nom = nom;
        this.prenom = prenom;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.dependence = dependence;
        this.departement = departement;
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

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getDependence() {
        return dependence;
    }

    public void setDependence(String dependence) {
        this.dependence = dependence;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    @Override
    public String toString() {
        return "{" +
                "nom:'" + this.getNom() + '\'' +
                ", prenom:'" + this.getPrenom() + '\'' +
                ", departement:'" + this.getDepartement() + '\'' +
                ", dependence:'" + this.getDependence() + '\'' +
                ", email:'" + this.getEmail() + '\'' +
                ", mobilePhone:'" + this.getMobilePhone() + '\'' +
                ", active:" + this.isActive() +
                '}';
    }
}
