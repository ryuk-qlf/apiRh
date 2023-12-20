package fr.facil.facilapi.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "User")
public class User {

    @Id
    private String id;
    private String username;
    private String password;
    private String email;

    private List<NoteDeFrais> noteDeFrais ;

    public List<jourTravail> getJoursDeTravail() {
        return joursDeTravail;
    }

    public List<NoteDeFrais> getNoteDeFrais() {
        return noteDeFrais;
    }

    public void setNoteDeFrais(List<NoteDeFrais> noteDeFrais) {
        this.noteDeFrais = noteDeFrais;
    }
    public void  addToList(NoteDeFrais uneNoteDeFrais){
        this.noteDeFrais.add(uneNoteDeFrais);
    }
    public void removeToList(NoteDeFrais uneNoteDeFrais){
        this.noteDeFrais.remove(uneNoteDeFrais);
    }
    public void addjTravail(jourTravail jTravail){this.joursDeTravail.add(jTravail);}

    public void setJoursDeTravail(List<jourTravail> jourDeTravail) {
        this.joursDeTravail = jourDeTravail;
    }

    private String first_name;
    private String last_name;
    private String mobilePhone;
    private double permission;
    private boolean active;
    private List<jourTravail> joursDeTravail ;



    public User(String username, String password, String first_name, String last_name, String email,double permission, boolean active, String mobilePhone) {

        this.username = username;
        this.password = password;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.mobilePhone = mobilePhone;
        this.permission = permission;
        this.active = active;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public double getPermission() {
        return permission;
    }

    public void setPermission(double permission) {
        this.permission = permission;
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

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    
}
