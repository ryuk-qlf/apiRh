package fr.facil.facilapi.repository;

import fr.facil.facilapi.collections.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NotificationRepository extends MongoRepository<Notification, String> {

    List<Notification> findAll();

    Notification findNotificationById(String id);

    List<Notification> findNotificationsByActiveIsTrue();

}
