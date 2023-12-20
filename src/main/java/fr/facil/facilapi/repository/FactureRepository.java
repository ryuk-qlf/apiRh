package fr.facil.facilapi.repository;

import fr.facil.facilapi.collections.Facture;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FactureRepository extends MongoRepository<Facture, String> {

    Facture findFactureById(String id);

    Facture findFactureByNumero(String numero);

}
