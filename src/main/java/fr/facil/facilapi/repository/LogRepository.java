package fr.facil.facilapi.repository;

import fr.facil.facilapi.collections.Log;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LogRepository extends MongoRepository<Log, String> {

    Log findLogById(String id);

    List<Log> findLogsByTypeAndNumeroBl(String type, String numero);

    List<Log> findLogsByMessage(String message);

}
