package fr.facil.facilapi.repository;

import fr.facil.facilapi.collections.DocumentPosition;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DocumentPositionRepository extends MongoRepository<DocumentPosition, String> {

    DocumentPosition findDocumentPositionById(String id);

    List<DocumentPosition> findDocumentPositionByClient_Name(String name);

    List<DocumentPosition> findDocumentPositionByType(String type);

    DocumentPosition findDocumentPositionByTypeAndClient_Name(String type, String client);

}
