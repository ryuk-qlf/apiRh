package fr.facil.facilapi.repository;

import fr.facil.facilapi.collections.TacheUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TacheUserRepository extends MongoRepository<TacheUser, String> {

    TacheUser findTacheUserById(String id);

}
