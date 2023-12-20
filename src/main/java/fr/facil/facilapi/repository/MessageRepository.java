package fr.facil.facilapi.repository;

import fr.facil.facilapi.collections.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, String> {

    List<Message> findMessagesByEmetter(String emetter);

}
