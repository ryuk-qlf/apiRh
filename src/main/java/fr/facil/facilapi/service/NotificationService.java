package fr.facil.facilapi.service;

import fr.facil.facilapi.collections.Notification;

import java.util.List;

public interface NotificationService {

    List<Notification> getNotifications();

    Notification addNotification(Notification notification);
}
