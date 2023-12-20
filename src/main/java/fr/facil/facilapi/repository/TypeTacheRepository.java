package fr.facil.facilapi.repository;

import fr.facil.facilapi.collections.TypeTache;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TypeTacheRepository extends MongoRepository<TypeTache, String> {

    TypeTache findTypeTacheById (String Id);

}
