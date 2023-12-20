package fr.facil.facilapi.controller;


import fr.facil.facilapi.collections.NoteDeFrais;
import fr.facil.facilapi.collections.User;
import fr.facil.facilapi.repository.NoteDeFraisRepository;
import fr.facil.facilapi.repository.UserRepository;
import fr.facil.facilapi.service.NoteDeFraisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/ndf")
public class NoteDeFraisController {

    @Autowired
    private NoteDeFraisRepository noteDeFraisRepo ;
    @Autowired
    private NoteDeFraisService noteDeFraisService ;
    @Autowired
    private UserRepository userRepository ;


    @GetMapping(value = "/")
    public List<NoteDeFrais> getJoursDetravail() {
        return  this.noteDeFraisService.findAll();
    }
    @GetMapping(value = "/findByDate/{date}")
    public NoteDeFrais getNoteDeFraisByDate(@PathVariable Date unedate){
        return this.noteDeFraisRepo.findByDate(unedate);
    }
    @GetMapping(value = "/findByPrenomAndNom/{prenom}/{nom}")
    public List<NoteDeFrais> getNoteDeFraisByFirstnameandName(@PathVariable String nom, @PathVariable String prenom){
        return this.noteDeFraisRepo.findByNameAndFirstname(nom ,prenom);
    }
    @GetMapping(value = "/addNoteDeFrais")
    public List<NoteDeFrais>  addNoteDeFrais(@PathVariable User user, @PathVariable NoteDeFrais uneNoteDeFrais){
        user.addToList(uneNoteDeFrais);
        this.userRepository.save(user);
        return user.getNoteDeFrais();
    }
}
