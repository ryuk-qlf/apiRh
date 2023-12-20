package fr.facil.facilapi.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "CV")
public class CV {

    /*

        ID
        CV_original
        CV_JSON
        CV_FACIL
        CV_HAKKA


     */

    @Id
    String Id;

    Object CV_original;
    String CV_json;
    Object CV_FACIL;
    Object Hakka;

}
