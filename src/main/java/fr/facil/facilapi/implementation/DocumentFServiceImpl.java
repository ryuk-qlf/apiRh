package fr.facil.facilapi.implementation;

import fr.facil.facilapi.collections.DocumentF;
import fr.facil.facilapi.repository.DocumentFRepository;
import fr.facil.facilapi.service.DocumentFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentFServiceImpl implements DocumentFService {

    @Autowired
    private DocumentFRepository repository;

    @Override
    public List<DocumentF> findAll() {
        return repository.findAll();
    }

    @Override
    public DocumentF findById(String id) {
        return repository.findDocumentFById(id);
    }

    @Override
    public DocumentF findByTitle(String title) {
        return repository.findDocumentFByTitle(title);
    }

    @Override
    public List<DocumentF> findByType(String type) {
        return repository.findDocumentFByType(type);
    }

    @Override
    public DocumentF add(DocumentF doc) {
        return repository.save(doc);
    }

    @Override
    public DocumentF remove(DocumentF doc) {

        DocumentF docModify = repository.findDocumentFById(doc.getId());

        docModify.setActive(false);
        repository.delete(docModify);
        return null;
    }
}
