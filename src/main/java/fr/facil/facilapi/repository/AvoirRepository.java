package fr.facil.facilapi.repository;

import fr.facil.facilapi.collections.Avoir;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AvoirRepository extends MongoRepository<Avoir, String> {


    Avoir findAvoirByFacture_Numero(String numero);
    Avoir findAvoirById(String id);

}
