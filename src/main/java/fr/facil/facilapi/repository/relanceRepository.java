package fr.facil.facilapi.repository;

import fr.facil.facilapi.collections.Relance;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface relanceRepository extends MongoRepository<Relance, String> {
    Relance findOneById(String id);

}
