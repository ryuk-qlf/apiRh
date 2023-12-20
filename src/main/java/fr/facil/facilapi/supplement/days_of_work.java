package fr.facil.facilapi.supplement;

public class days_of_work {

    private String libelle;
    private int month;
    private int year;
    private float number_of_work;

    private double price;

    public days_of_work(String libelle, int month, int year, float number_of_work, double price) {
        this.libelle = libelle;
        this.month = month;
        this.year = year;
        this.number_of_work = number_of_work;
        this.price = price;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getNumber_of_work() {
        return number_of_work;
    }

    public void setNumber_of_work(float number_of_work) {
        this.number_of_work = number_of_work;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
