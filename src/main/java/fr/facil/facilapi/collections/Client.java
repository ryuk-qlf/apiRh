package fr.facil.facilapi.collections;

import fr.facil.facilapi.supplement.Managers;
import fr.facil.facilapi.supplement.rAchat;
import fr.facil.facilapi.type.Type_BL;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "Client")
public class Client {

    @Id
    private String id;
    private String name;
    private String nameofagence;
    private String number_fix;
    private String address;
    private String city;
    private String zip_code;
    private String country;
    private boolean type_bl;
    private boolean valid_facture;

    private double dayOfReglement;
    private List<Managers> managers;

    private List<rAchat> achat;


    public Client(String id, String name, String nameofagence, String number_fix, String address, String city, String zip_code, String country, boolean type_bl, boolean valid_facture, double dayOfReglement, List<Managers> managers, List<rAchat> achat) {
        this.id = id;
        this.name = name;
        this.nameofagence = nameofagence;
        this.number_fix = number_fix;
        this.address = address;
        this.city = city;
        this.zip_code = zip_code;
        this.country = country;
        this.type_bl = type_bl;
        this.valid_facture = valid_facture;
        this.dayOfReglement = dayOfReglement;
        this.managers = managers;
        this.achat = achat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameofagence() {
        return nameofagence;
    }

    public void setNameofagence(String nameofagence) {
        this.nameofagence = nameofagence;
    }

    public String getNumber_fix() {
        return number_fix;
    }

    public void setNumber_fix(String number_fix) {
        this.number_fix = number_fix;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isType_bl() {
        return type_bl;
    }

    public void setType_bl(boolean type_bl) {
        this.type_bl = type_bl;
    }

    public List<Managers> getManagers() {
        return managers;
    }

    public void setManagers(List<Managers> managers) {
        this.managers = managers;
    }

    public double getDayOfReglement() {
        return dayOfReglement;
    }

    public void setDayOfReglement(double dayOfReglement) {
        this.dayOfReglement = dayOfReglement;
    }

    public boolean isValid_facture() {
        return valid_facture;
    }

    public void setValid_facture(boolean valid_facture) {
        this.valid_facture = valid_facture;
    }

    public List<rAchat> getAchat() {
        return achat;
    }

    public void setAchat(List<rAchat> achat) {
        this.achat = achat;
    }
}
