package fr.facil.facilapi.supplement;

public class Timeformat {

    private String h;

    private String m;

    public Timeformat(String h, String m) {
        this.h = h;
        this.m = m;
    }

    public String getH() {
        return h;
    }

    public void setH(String h) {
        this.h = h;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }
}
