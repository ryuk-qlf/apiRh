package fr.facil.facilapi.repository;

import fr.facil.facilapi.collections.Calendar;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CalendarRepository extends MongoRepository<Calendar, String> {

    Calendar findOneById(String id);

}
