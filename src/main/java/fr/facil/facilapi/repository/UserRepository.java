package fr.facil.facilapi.repository;

import fr.facil.facilapi.collections.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    User findUserByUsername(String username);

    User findUserById(String id);

    User findUserByUsernameAndPassword(String username, String password);

    User findUserByEmail(String email);

    List<User> findAllByActiveIsTrue();

}
