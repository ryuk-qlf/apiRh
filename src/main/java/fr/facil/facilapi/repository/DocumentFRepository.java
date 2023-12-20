package fr.facil.facilapi.repository;

import fr.facil.facilapi.collections.DocumentF;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DocumentFRepository extends MongoRepository<DocumentF, String> {

    DocumentF findDocumentFById(String id);

    DocumentF findDocumentFByTitle(String title);

    List<DocumentF> findDocumentFByType(String type);

}
