package fr.facil.facilapi.controller;

import fr.facil.facilapi.collections.Tache;
import fr.facil.facilapi.repository.TacheRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LoggingInitializationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tache")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TacheRestController {

    @Autowired
    private TacheRepository tacheRepository;

    Logger logger = LoggerFactory.getLogger(LoggingInitializationContext.class);

    @GetMapping(value = "/")
    public List<Tache> getAllTache() {
        return tacheRepository.findAll();
    }

    @GetMapping(value = "/{tacheId}")
    public Tache getTacheById(@PathVariable String tacheId){
        return tacheRepository.findTacheById(tacheId);
    }

    @PostMapping(value = "/create")
    public Tache addTache(@RequestBody Tache tache){
        return tacheRepository.save(tache);
    }

    @DeleteMapping(value = "/delete/{tacheId}")
    public void deleteTache(@PathVariable String tacheId){
        tacheRepository.deleteById(tacheId);
    }

    @PutMapping(value = "/update/{tacheId}")
    public Tache updateTache(@PathVariable String tacheId, @RequestBody Tache tache){
        tache.setId(tacheId);

        return tacheRepository.save(tache);
    }



}
