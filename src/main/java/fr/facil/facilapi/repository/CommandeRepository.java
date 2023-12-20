package fr.facil.facilapi.repository;

import fr.facil.facilapi.collections.Commande;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommandeRepository extends MongoRepository<Commande, String> {

    Commande findCommandeById(String id);

    Commande findCommandeByNumero(String numero);

}
