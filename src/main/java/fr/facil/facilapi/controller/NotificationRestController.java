package fr.facil.facilapi.controller;

import fr.facil.facilapi.collections.Notification;
import fr.facil.facilapi.repository.NotificationRepository;
import fr.facil.facilapi.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notif")
@CrossOrigin(origins = "*", maxAge = 3600)
public class NotificationRestController {

    @Autowired
    private NotificationRepository repository;

    @Autowired
    private NotificationService Service;


    @GetMapping(value = "/")
    public List<Notification> getNotifications() {
        return this.Service.getNotifications();
    }

    @PutMapping(value = "/")
    public Notification addNotification(@RequestBody Notification notification){
        return this.Service.addNotification(notification);
    }

    @DeleteMapping(value = "/{id}")
    public Notification addNotification(@PathVariable String id){
        Notification notif = this.repository.findNotificationById(id);

        notif.setActive(false);


        return this.repository.save(notif);
    }

}
