package fr.facil.facilapi.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Ticket")
public class Ticket {

    @Id
    private String id;

    private String title;

    private String description;

    private User user;

    private String createdAt;

    private boolean active;

}
