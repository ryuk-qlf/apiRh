package fr.facil.facilapi.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Droit {


    private Double panierRepas;

    private int passNavigo;

    private boolean essence;

    public Droit(Double panierRepas, int passNavigo, boolean essence) {
        this.panierRepas = panierRepas;
        this.passNavigo = passNavigo;
        this.essence = essence;
    }


    public Double getPanierRepas() {
        return panierRepas;
    }

    public void setPanierRepas(Double panierRepas) {
        this.panierRepas = panierRepas;
    }

    public int getPassNavigo() {
        return passNavigo;
    }

    public void setPassNavigo(int passNavigo) {
        this.passNavigo = passNavigo;
    }

    public boolean getEssence() {
        return essence;
    }

    public void setEssence(boolean essence) {
        this.essence = essence;
    }
}
