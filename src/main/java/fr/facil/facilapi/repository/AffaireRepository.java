package fr.facil.facilapi.repository;

import fr.facil.facilapi.collections.Affaire;
import fr.facil.facilapi.collections.Ressource_Humaine;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AffaireRepository extends MongoRepository<Affaire, String> {

    Affaire findAffaireById(String id);

    Affaire findAffaireByReference(String ref);

    List<Affaire> findAllByClient_Name(String name);

    List<Affaire> findAffairesByRh(Ressource_Humaine rh);

    List<Affaire> findAllByRh_Id(String id);

}
