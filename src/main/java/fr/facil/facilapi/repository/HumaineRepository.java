package fr.facil.facilapi.repository;

import fr.facil.facilapi.collections.Ressource_Humaine;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HumaineRepository extends MongoRepository<Ressource_Humaine, String> {

    Ressource_Humaine findRessource_HumaineById(String id);

    Ressource_Humaine findRessource_HumaineByLastname(String id);

    Ressource_Humaine findRessource_HumaineByLastnameAndFirstname(String Lastname, String Firstname);

    void deleteByLastnameAndFirstname(String lastname, String firstname);





}
