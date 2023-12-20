package fr.facil.facilapi.repository;

import fr.facil.facilapi.collections.Candidat;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CandidatRepository extends MongoRepository<Candidat, String>{

    Candidat findCandidatById(String id);

   // Candidat findCandidatByNomAnAndPrenom(String nom, String prenom);

}
