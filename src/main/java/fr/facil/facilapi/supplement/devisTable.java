package fr.facil.facilapi.supplement;

import lombok.Data;

@Data
public class devisTable {

    private String title;
    private double quantity;
    private double priceUnits;
    private double price;

    public devisTable(String title, double quantity, double priceUnits, double price) {
        this.title = title;
        this.quantity = quantity;
        this.priceUnits = priceUnits;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPriceUnits() {
        return priceUnits;
    }

    public void setPriceUnits(double priceUnits) {
        this.priceUnits = priceUnits;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
