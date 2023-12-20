package fr.facil.facilapi.repository;

import fr.facil.facilapi.collections.ValidateBl;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ValidateBlRepository extends MongoRepository<ValidateBl, String> {

    ValidateBl findValidateBlById(String id);

    ValidateBl findValidateBlByBl(ObjectId bl);

    List<ValidateBl> findValidateBlByAffaire(ObjectId affaire);

    List<ValidateBl> findValidateBlByCommande(ObjectId commande);

    List<ValidateBl> findValidateBlByActive(boolean active);

    List<ValidateBl> findValidateBlByStatus(String status);

    List<ValidateBl> findValidateBlByActiveAndStatus( boolean active,String status);

}
