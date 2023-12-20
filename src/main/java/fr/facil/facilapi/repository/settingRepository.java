package fr.facil.facilapi.repository;

import fr.facil.facilapi.supplement.Setting;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface settingRepository extends MongoRepository<Setting, String> {

    Setting findSettingById(String id);

}
