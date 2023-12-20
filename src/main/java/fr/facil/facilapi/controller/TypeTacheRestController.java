package fr.facil.facilapi.controller;

import fr.facil.facilapi.collections.TypeTache;
import fr.facil.facilapi.repository.TypeTacheRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.logging.LoggingInitializationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TypeTacheRestController {

    private TypeTacheRepository typeRepository;

    Logger logger = LoggerFactory.getLogger(LoggingInitializationContext.class);

    @GetMapping("/")
    public List<TypeTache> getAllTypeTache() {
        return typeRepository.findAll();
    }

    @GetMapping("/{typetacheId}")
    public TypeTache getTypeTacheById(@PathVariable String typetacheId){
        return typeRepository.findTypeTacheById(typetacheId);
    }

    @PostMapping(value = "/create")
    public TypeTache addTypeTache(@RequestBody TypeTache typeTache){
        return typeRepository.save(typeTache);
    }

    @DeleteMapping("/delete/{typetacheId}")
    public void deleteTypeTache(@PathVariable String typetacheId){
        typeRepository.deleteById(typetacheId);
    }

    @PutMapping("/update/{typetacheId}")
    public TypeTache updateTache(@PathVariable String typetacheId, @RequestBody TypeTache type){
        type.setId(typetacheId);

        return typeRepository.save(type);
    }

}
