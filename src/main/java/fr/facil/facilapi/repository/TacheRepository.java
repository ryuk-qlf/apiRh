package fr.facil.facilapi.repository;

import fr.facil.facilapi.collections.Tache;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TacheRepository extends MongoRepository<Tache, String> {

    Tache findTacheById(String id);

}
