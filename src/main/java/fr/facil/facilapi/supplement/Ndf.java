package fr.facil.facilapi.supplement;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Ndf")
public class Ndf {

    private String title;
    private int quantite;
    private double priceTTC;

    private boolean exceptionnel;
    private String date;

    public Ndf(String title, int quantite, double priceTTC, boolean exceptionnel, String date) {
        this.title = title;
        this.quantite = quantite;
        this.priceTTC = priceTTC;
        this.exceptionnel = exceptionnel;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double isPriceTTC() {
        return priceTTC;
    }

    public void setPriceTTC(double priceTTC) {
        this.priceTTC = priceTTC;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isExceptionnel() {
        return exceptionnel;
    }

    public void setExceptionnel(boolean exceptionnel) {
        this.exceptionnel = exceptionnel;
    }
}
