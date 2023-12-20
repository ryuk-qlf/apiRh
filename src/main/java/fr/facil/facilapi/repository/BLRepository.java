package fr.facil.facilapi.repository;

import fr.facil.facilapi.collections.BL;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BLRepository extends MongoRepository<BL, String> {

    BL findBlById(String id);

    BL findBLByNum(String id);

}
