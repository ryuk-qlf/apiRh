package fr.facil.facilapi.service;

import fr.facil.facilapi.collections.DocumentF;

import java.util.List;

public interface DocumentFService {

    List<DocumentF> findAll();

    DocumentF findById(String id);

    DocumentF findByTitle(String title);

    List<DocumentF> findByType(String type);

    DocumentF add(DocumentF doc);

    DocumentF remove(DocumentF doc);
}
