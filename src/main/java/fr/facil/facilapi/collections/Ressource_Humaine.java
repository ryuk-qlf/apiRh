package fr.facil.facilapi.collections;

import fr.facil.facilapi.supplement.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "Ressource_Humaine")
public class Ressource_Humaine {

    @Id
    private String id;

    private String firstname;
    private String lastname;
    private List<days_of_work> days_of_month;
    private List<Ndf> ndf;

    private boolean active;
    private String start;
    private String typeContrat;
    private String adresse;
    private String ville;
    private String cp;
    private String pays;
    private String numeroSecu;
    private String nationality;
    private String dateOfBirth;
    private String numberSejour;
    private String mobilePhone;
    private String email;
    private double position;
    private double coefficient;
    private boolean cadre;
    private double tj;
    private double time;

    //Civilité
    /*
        dateDebutContrat
        dateFinContrat
        periodeJours
        OBject<etablissement> SCT FACIL

        etablissement{

            nom
            prenom
            intitulé
            adresse
            siret
            ape
            email
            telephone

        }

        BrutAnuelle
        BrutMensuel
        DateEmission
        visiteMedical

     */

    public Ressource_Humaine(String firstname, String lastname, List<days_of_work> days_of_month, List<Ndf> ndf, /*Droit droit,*/boolean active, String start, String typeContrat, String adresse, String ville, String cp, String pays, String numeroSecu, String nationality, String dateOfBirth, String numberSejour, String mobilePhone, String email, Double position, Double coefficient, boolean cadre, Double tj, Double time) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.days_of_month = days_of_month;
        this.ndf = ndf;
        this.active = active;
        this.start = start;
        this.typeContrat = typeContrat;
        this.adresse = adresse;
        this.ville = ville;
        this.cp = cp;
        this.pays = pays;
        this.numeroSecu = numeroSecu;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.numberSejour = numberSejour;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.position = position;
        this.coefficient = coefficient;
        this.cadre = cadre;
        this.tj = tj;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<days_of_work> getDays_of_month() {
        return days_of_month;
    }

    public void setDays_of_month(List<days_of_work> days_of_month) {
        this.days_of_month = days_of_month;
    }

    public List<Ndf> getNdf() {
        return ndf;
    }

    public void setNdf(List<Ndf> ndf) {
        this.ndf = ndf;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(String typeContrat) {
        this.typeContrat = typeContrat;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getNumeroSecu() {
        return numeroSecu;
    }

    public void setNumeroSecu(String numeroSecu) {
        this.numeroSecu = numeroSecu;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNumberSejour() {
        return numberSejour;
    }

    public void setNumberSejour(String numberSejour) {
        this.numberSejour = numberSejour;
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

    public double getPosition() {
        return position;
    }

    public void setPosition(double position) {
        this.position = position;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public boolean isCadre() {
        return cadre;
    }

    public void setCadre(boolean cadre) {
        this.cadre = cadre;
    }

    public double getTj() {
        return tj;
    }

    public void setTj(double tj) {
        this.tj = tj;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public void addNdf(Ndf ndf) {
        this.ndf.add(ndf);
    }

    public void addHour(days_of_work dow) {
        this.days_of_month.add(dow);
    }
}
