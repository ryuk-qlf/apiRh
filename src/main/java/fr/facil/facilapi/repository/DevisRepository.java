package fr.facil.facilapi.repository;

import fr.facil.facilapi.collections.Devis;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DevisRepository extends MongoRepository<Devis, String> {

    Devis findDevisById(String id);

    Devis findDevisByNum(String num);

    Devis findDevisByClient_Name(String clientName);

}
