package fr.facil.facilapi.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class LieuTache {

    @Id
    private String Id;

    private String LibLieu;

    public LieuTache(String libLieu) {
        LibLieu = libLieu;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getLibLieu() {
        return LibLieu;
    }

    public void setLibLieu(String libLieu) {
        LibLieu = libLieu;
    }
}
