package fr.facil.facilapi.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "TypeTache")
public class TypeTache {

    @Id
    private String Id;

    private String libType;

    public TypeTache(String libType) {
        this.libType = libType;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getlibType() {
        return libType;
    }

    public void setlibType(String libType) {
        this.libType = libType;
    }
}
