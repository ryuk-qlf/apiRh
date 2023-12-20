package fr.facil.facilapi.repository;

import fr.facil.facilapi.collections.Yousign_document;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface YousignDocRepository extends MongoRepository<Yousign_document, String> {

    Yousign_document findYousign_documentById(String id);

    Yousign_document findYousign_documentByTypeAndNum(String type, String num);

}
