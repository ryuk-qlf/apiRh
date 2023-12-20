package fr.facil.facilapi.repository;

import fr.facil.facilapi.collections.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client, String> {

    Client findClientsById(String id);

    Client findClientsByName(String name);

}
