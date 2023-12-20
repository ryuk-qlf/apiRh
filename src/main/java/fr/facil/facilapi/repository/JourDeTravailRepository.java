package fr.facil.facilapi.repository;

import fr.facil.facilapi.collections.Ressource_Humaine;
import fr.facil.facilapi.collections.jourTravail;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface JourDeTravailRepository extends MongoRepository<jourTravail, String> {

   List<jourTravail> findAll();

   jourTravail findJourTravailById(Integer id);

   jourTravail findJourTravailByRh(Ressource_Humaine rh);



}
