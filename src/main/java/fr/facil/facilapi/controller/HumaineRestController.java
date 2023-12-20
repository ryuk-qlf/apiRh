package fr.facil.facilapi.controller;

import fr.facil.facilapi.collections.Ressource_Humaine;
import fr.facil.facilapi.repository.HumaineRepository;
import fr.facil.facilapi.supplement.Ndf;
import fr.facil.facilapi.supplement.days_of_work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rs")
@CrossOrigin(origins = "*", maxAge = 3600)
public class HumaineRestController {

    @Autowired
    private HumaineRepository HumaineRepository;


    //find all collab
    @GetMapping(value = "/")
    public List<Ressource_Humaine> getAllUsers() {
        return HumaineRepository.findAll();
    }

    @GetMapping(value = "/find/{lastname}")
    public Ressource_Humaine getUsersByLastName(@PathVariable String lastname) {
        return HumaineRepository.findRessource_HumaineByLastname(lastname);
    }

    @GetMapping(value = "/find/{lastname}/{firstname}")
    public Ressource_Humaine getUsersByLastNameAndFirstName(@PathVariable String lastname, @PathVariable String firstname) {
        return HumaineRepository.findRessource_HumaineByLastnameAndFirstname(lastname, firstname);
    }

    //find one by id
    @GetMapping(value = "/{id}")
    public Ressource_Humaine getUserById(@PathVariable String id) {
        return HumaineRepository.findRessource_HumaineById(id);
    }

    //create un collab
    @PostMapping(value = "/create")
    public Ressource_Humaine addUser(@RequestBody Ressource_Humaine rs) {
        return HumaineRepository.save(rs);
    }

    //delete un collab
    @DeleteMapping(value = "/delete/{rsId}")
    public void deleteUser(@PathVariable String rsId) {
        HumaineRepository.deleteById(rsId);
    }

    @DeleteMapping(value = "/deletebynom/{rsnom}/{rsprenom}")
    public void deleteUser(@PathVariable String rsnom, @PathVariable String rsprenom) {
        HumaineRepository.deleteByLastnameAndFirstname(rsnom, rsprenom);
    }

    @PostMapping(value = "/setactive/{rsnom}/{rsprenom}")
    public Ressource_Humaine setActiveFalseRs(@PathVariable String rsnom, @PathVariable String rsprenom) {

        Ressource_Humaine rs = HumaineRepository.findRessource_HumaineByLastnameAndFirstname(rsnom, rsprenom);

        rs.setActive(false);

        return HumaineRepository.save(rs);
    }


    /**
     * Il prend une liste d'objets Ndf et une chaîne idrs comme paramètres, trouve l'objet Ressource_Humaine avec
     * l'identifiant idrs, ajoute les objets Ndf à l'objet Ressource_Humaine et enregistre l'objet Ressource_Humaine.
     *
     * @param ndf La liste des objets Ndf à ajouter à l'objet Ressource_Humaine.
     * @param idrs l'identifiant de la ressource humaine
     * @return Une liste de Ndf
     */
    @PostMapping(value = "/addndf/{idrs}")
    public Ressource_Humaine addNdf(@RequestBody List<Ndf> ndf, @PathVariable String idrs){
        Ressource_Humaine rh = HumaineRepository.findRessource_HumaineById(idrs);
        for (Ndf x : ndf) {
            rh.addNdf(x);
        }

        return HumaineRepository.save(rh);
    }

    @PostMapping(value = "/addhour/{firstName}/{lastName}/{month}")
    public Ressource_Humaine addHour(@RequestBody days_of_work dow, @PathVariable String firstName, @PathVariable String lastName, @PathVariable int month){
        Ressource_Humaine rh = HumaineRepository.findRessource_HumaineByLastnameAndFirstname(lastName, firstName);
        //affaireServiceImpl service = null;
        for (days_of_work monJours : rh.getDays_of_month()){
            if (monJours.getMonth() == month){
                monJours.setNumber_of_work(dow.getNumber_of_work());
                monJours.setPrice(dow.getPrice());

                //service.updateAllDayOfCollab(lastName, firstName, dow.getNumber_of_work(), month, dow.getYear());
                return HumaineRepository.save(rh);
            }else {
                if (monJours.getMonth() == dow.getMonth())
                    if (monJours.getYear() == dow.getYear()) {
                        monJours.setNumber_of_work(dow.getNumber_of_work());
                        monJours.setPrice(dow.getPrice());
                        //service.updateAllDayOfCollab(lastName, firstName, dow.getNumber_of_work(), month, dow.getYear());
                        return HumaineRepository.save(rh);
                    } else {
                        rh.addHour(dow);
                        //service.updateAllDayOfCollab(lastName, firstName, dow.getNumber_of_work(), month, dow.getYear());
                        return HumaineRepository.save(rh);
                    }
            }
        }

        rh.addHour(dow);
        //service.updateAllDayOfCollab(lastName, firstName, dow.getNumber_of_work(), month, dow.getYear());
        return HumaineRepository.save(rh);
    }

}


