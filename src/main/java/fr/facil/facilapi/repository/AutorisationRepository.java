package fr.facil.facilapi.repository;

import fr.facil.facilapi.collections.Autorisation_BL;
import fr.facil.facilapi.collections.BL;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AutorisationRepository extends MongoRepository<Autorisation_BL, String> {

    Autorisation_BL getAutorisationById(String id);

    Autorisation_BL getAutorisationByBL(BL object);

}
