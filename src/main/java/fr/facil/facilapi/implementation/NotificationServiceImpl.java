package fr.facil.facilapi.implementation;

import fr.facil.facilapi.collections.Notification;
import fr.facil.facilapi.repository.NotificationRepository;
import fr.facil.facilapi.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {


    @Autowired
    private NotificationRepository repo;

    @Override
    public List<Notification> getNotifications() {
        return this.repo.findAll();
    }

    @Override
    public Notification addNotification(Notification notification) {
        return this.repo.save(notification);
    }
}
