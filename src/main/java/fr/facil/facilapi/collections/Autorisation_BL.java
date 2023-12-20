package fr.facil.facilapi.collections;

import fr.facil.facilapi.type.Autorise;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Autorisation_BL")
public class Autorisation_BL {

    @Id
    private String id;

    private BL bl;

    private Autorise autorise;

    public Autorisation_BL(BL bl, Autorise autorise) {
        this.bl = bl;
        this.autorise = autorise;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BL getBL() {
        return bl;
    }

    public void setBL(BL bl) {
        this.bl = bl;
    }

    public Autorise isAutorise() {
        return autorise;
    }

    public void setAutorise(Autorise autorise) {
        this.autorise = autorise;
    }
}
